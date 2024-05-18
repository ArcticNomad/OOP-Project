package com.example.trainManagementProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectionController {

    @FXML
    private Button button;
    @FXML
    private Button passengerButton;

    public void onAdminButtonClick() throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("adminLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
        stage.setScene(scene);
        stage.show();
    }
    public void onPassengerButton()
    {
        Stage stage=(Stage) passengerButton.getScene().getWindow();
        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("addPassenger.fxml"));
        Scene scene;
        try {
            scene=new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }
}
