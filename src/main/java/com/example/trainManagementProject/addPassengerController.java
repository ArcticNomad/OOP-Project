package com.example.trainManagementProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class addPassengerController
{
    @FXML
    private Button doneButton;


    public void onDoneButton() throws IOException {
        Stage stage=(Stage) doneButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("mainPassengerPage.FXML"));

        Scene scene=new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }

}
