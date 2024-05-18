package com.example.trainmanagementproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {
    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    @FXML

    private final String adminPassword = "admin123";

    public void verifyPassword() throws IOException {
        if (passwordField.getText().equals(adminPassword)) {
            Stage stage = (Stage) passwordField.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainAdminPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
            stage.setScene(scene);
            stage.show();
        } else {
            loginButton.setText("Incorrect !");
        }
    }
}
