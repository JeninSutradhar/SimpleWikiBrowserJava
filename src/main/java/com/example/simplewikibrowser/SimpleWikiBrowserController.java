package com.example.simplewikibrowser;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SimpleWikiBrowserController {

    @FXML
    private TextField searchField;

    @FXML
    private WebView webView;

    private WebEngine webEngine;

    @FXML
    public void initialize() {
        webEngine = webView.getEngine();
        webEngine.load("https://www.wikipedia.org/"); // Load Wikipedia home page by default
    }

    @FXML
    public void handleSearch() {
        String searchTerm = searchField.getText().trim();
        if (!searchTerm.isEmpty()) {
            String searchUrl = "https://en.wikipedia.org/wiki/" + searchTerm.replace(" ", "_");
            webEngine.load(searchUrl);
        }
    }
}
