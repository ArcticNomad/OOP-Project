package com.example.trainManagementProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class mainPassengerPageController
{
    @FXML
    private Button buyTicketButton;


    public void onBuyTicketButton()
    {
        Stage stage=(Stage) buyTicketButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("BuyTicket.fxml"));

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
