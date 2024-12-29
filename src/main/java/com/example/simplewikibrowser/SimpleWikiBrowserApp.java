package com.example.simplewikibrowser;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleWikiBrowserApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            getClass().getResource("/simple-wiki-browser.fxml") // Adjust path here
        );
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Simple Wiki Browser (JavaFX)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Pass args to launch
    }
}