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

public class ticketDetailController implements Initializable {
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
        errorField.setEditable(false);
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

        try
        {
            long ID =mainTicketDetailsPageController.getID();

            for (int i = 0; i < StationManagement.getPassengers().size(); i++)
            {
                if (ID == StationManagement.getPassengers().get(i).getPassengerID())
                {
                    passengerName.setText(StationManagement.getPassengers().get(i).getFirstName()+ " " + StationManagement.getPassengers().get(i).getLastName());
                    String id = String.valueOf(StationManagement.getPassengers().get(i).getPassengerID());
                    cnic.setText(id);
                    from.setText(StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getDepartureStation().getStationName() + " - " + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getDepartureStation().getCity());
                    to.setText(StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getArrivalStation().getStationName() + " - " + StationManagement.getPassengerTicket().getTicketTrain().getTrainRoute().getArrivalStation().getCity());

                    String day = String.valueOf(StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartDay());
                    date.setText(day + "/" + StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartMonth() + "/" + StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartYear());
                    String Price = String.valueOf(Double.valueOf(String.valueOf(StationManagement.getPassengers().get(i).getPassengerTicket().getFare())));
                    price.setText(Price);
                    departureTime.setText(StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartureHour() + "/" + StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDepartureMin() + "/" + StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getDeparture_AM_PM());
                    arrivalTime.setText(StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getArrivalHour() + "/" + StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getArrivalMin() + "/" + StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainRoute().getTrainTiming().getArrival_AM_PM());
                    String number = String.valueOf(StationManagement.getPassengers().get(i).getPassengerTicket().getTicketTrain().getTrainNUmber());
                    trainNumber.setText(number);
                    String SeatNumber = String.valueOf(StationManagement.getPassengers().get(i).getPassengerTicket().getPassengerSeat());
                    seatNumber.setText(SeatNumber);

            }
        } }catch(NullPointerException e)
        {
            errorField.setText("No Ticket Purchased !");
        }
    }


    public void onBackButton() throws IOException {

        Stage stage=(Stage) backButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("mainPassengerPage.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
}
