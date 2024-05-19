package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ticketDetailController implements Initializable
{
    @FXML
    private TextField passengerName;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField date;
    @FXML
    private TextField trainType;
    @FXML
    private TextField departureTime;
    @FXML
    private TextField arrivalTime;
    @FXML
    private TextField trainNumber;
    @FXML
    private TextField seatNumber;
    @FXML
    private TextField price;
    @FXML
    private TextField cnic;
    @FXML
    private Button backButton;
    @FXML
    private TextField errorField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        passengerName.setEditable(false);
        from.setEditable(false);
        to.setEditable(false);
        date.setEditable(false);
        departureTime.setEditable(false);
        arrivalTime.setEditable(false);
        trainNumber.setEditable(false);
        seatNumber.setEditable(false);
        price.setEditable(false);
        cnic.setEditable(false);

        try {
            passengerName.setText(StationManagement.getPassengerTicket().getPassenger().getFirstName() + " " + StationManagement.getPassengerTicket().getPassenger().getLastName());
            from.setText(StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getDepartureStation().getStationName());
            to.setText(StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getArrivalStation().getStationName());

            String day = String.valueOf(StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartDay());
            date.setText(day + "/" + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartMonth() + "/" + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartYear());
            String Price = String.valueOf(Double.valueOf(String.valueOf(StationManagement.getPassengerTicket().getFare())));
            price.setText(Price);
            departureTime.setText(StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartureHour() + "/" + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartureMin() + "/" + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDeparture_AM_PM());
            arrivalTime.setText(StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getArrivalHour() + "/" + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getArrivalMin() + "/" + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getArrival_AM_PM());
            String number = String.valueOf(StationManagement.getPassengerTicket().getTicketTrain().getTrainNUmber());
            trainNumber.setText(number);
            String SeatNumber = StationManagement.getPassengerTicket().getPassengerSeat().toString();
            seatNumber.setText(SeatNumber);
        }catch (NullPointerException e)
        {

        }


    }

    public void onBackButton() throws IOException {

        Stage stage=(Stage) backButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("addPassenger.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
}
