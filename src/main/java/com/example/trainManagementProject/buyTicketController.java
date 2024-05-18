package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.Route.Route;
import com.example.trainManagementProject.backendClasses.Ticket.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class buyTicketController
{
    @FXML
    private Ticket passengerTicket=null;

    @FXML
    private TextField departStationName;
    @FXML
    private TextField destinationStationName;
    @FXML
    private TextField distance;
    @FXML
    private TextField seatNo;
    @FXML
    Button paymentButton;

    public void onPaymentButton() throws IOException {

        Route.distanceBetweenStations= Integer.parseInt(distance.getText());

        Stage stage= (Stage) paymentButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("paymentPage"));
        Scene scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


}
