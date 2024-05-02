package SimpleWikiBrowser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleWikiBrowser extends JFrame {
    private JTextField searchField;
    private JTextArea resultArea;
    private JButton searchButton;

    public SimpleWikiBrowser() {
        createUI();
    }

    private void createUI() {
        setTitle("Simple Wiki Browser");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Search panel with dark theme
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.BLACK);
        searchField = new JTextField(50);
        searchField.setBackground(Color.DARK_GRAY);
        searchField.setForeground(Color.WHITE);
        searchButton = new JButton("Search");
        searchButton.setBackground(Color.DARK_GRAY);
        searchButton.setForeground(Color.WHITE);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Result area with word wrap and dark theme
        resultArea = new JTextArea();
        resultArea.setWrapStyleWord(true);
        resultArea.setLineWrap(true);
        resultArea.setEditable(false);
        resultArea.setBackground(Color.DARK_GRAY);
        resultArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.DARK_GRAY);

        // Add components to frame
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action listener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchWikipedia(searchField.getText());
            }
        });
    }

    private String extractTextFromFirstParagraph(String htmlContent) {
        String startTag = "<p>";
        String endTag = "</p>";
        int startIndex = htmlContent.indexOf(startTag) + startTag.length();
        int endIndex = htmlContent.indexOf(endTag, startIndex);
        if (startIndex > startTag.length() - 1 && endIndex > -1 && endIndex > startIndex) {
            String paragraph = htmlContent.substring(startIndex, endIndex).trim();
            // Remove HTML tags from the paragraph
            return paragraph.replaceAll("<[^>]+>", "");
        } else {
            return "No paragraph found or invalid HTML content.";
        }
    }

    private void searchWikipedia(String query) {
        try {
            String urlString = "https://en.wikipedia.org/wiki/" + query.replace(" ", "_");
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                content.append(System.lineSeparator());
            }
            in.close();

            // Instead of resultArea.setText(content.toString());
            String parsedContent = extractTextFromFirstParagraph(content.toString());
            resultArea.setText(parsedContent);
        } catch (Exception ex) {
            ex.printStackTrace();
            resultArea.setText("Error fetching data. Please try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleWikiBrowser browser = new SimpleWikiBrowser();
                browser.setVisible(true);
            }
        });
    }
}