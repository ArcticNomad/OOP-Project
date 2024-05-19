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
    @FXML
    private Button backButton;
    @FXML
    private Button feedbackButton;
    @FXML
    private  Button ticketDetailsButton;

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

    public void onBackButton() throws IOException {

        Stage stage=(Stage) backButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("addPassenger.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
    public void onFeedbackButton() throws IOException {
        Stage stage= (Stage) feedbackButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("feedbackPage.FXML"));

        Scene scene=new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
    public void onTicketDetailsButton() throws IOException {
        try {
            Stage stage = (Stage) ticketDetailsButton.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketDetails.FXML"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);

            stage.show();
        }catch (NullPointerException e){
            ticketDetailsButton.setText("Error!");
        }
    }


}
