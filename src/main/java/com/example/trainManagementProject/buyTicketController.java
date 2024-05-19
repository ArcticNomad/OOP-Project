package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.Route.Route;
import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import com.example.trainManagementProject.backendClasses.Ticket.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class buyTicketController
{
    @FXML
    private Ticket passengerTicket=new Ticket();

    @FXML
    private TextField departStationName;
    @FXML
    private TextField destinationStationName;
    @FXML
    private TextField distance;
    @FXML
    private TextField seatNo;
    @FXML
    private TextArea stationList;
    @FXML
    private TextArea seatList;
    @FXML
    private Button payButton;
    @FXML
    private Button businessClassButton;
    @FXML
    private Button economyClassButton;

    public void onPaymentButton() throws IOException {


        if(departStationName.getText().isEmpty()||destinationStationName.getText().isEmpty()||distance.getText().isEmpty()||seatNo.getText().isEmpty()|| !businessClassButton.isPressed() && !economyClassButton.isPressed())
        {
            payButton.setText("Error!");
        }

        Boolean trainFound=false;
        for (int i = 0; i < StationManagement.getTrains().size(); i++)
        {
            if(StationManagement.getTrains().get(i).getTrainRoute().getDepartureStation().equals(departStationName) && StationManagement.getTrains().get(i).getTrainRoute().getArrivalStation().equals(destinationStationName))
            {
                passengerTicket.setTicketTrain(StationManagement.getTrains().get(i));
                trainFound=true;
            }
        }
        if (!trainFound)
        {
            payButton.setText("Train Not Found !");
        }
        else {
            Stage stage = (Stage) payButton.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("paymentPage.FXML"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        }
    }

    public void onStationRefreshButton()
    {
        stationList.clear();

        for (int i = 0; i < StationManagement.getStations().size(); i++) {
            stationList.appendText("Station " + (i + 1) + " - " + StationManagement.getStations().get(i).getStationName() + "\n");
        }
    }
    public void onSeatRefreshButton()
    {
        seatList.clear();

        for (int i = 0; i <StationManagement.getTrains().size(); i++)
        {
            if(StationManagement.getTrains().get(i).getTrainRoute().getDepartureStation().equals(departStationName) && StationManagement.getTrains().get(i).getTrainRoute().getArrivalStation().equals(destinationStationName))
            {
                for (int j = 0; j < StationManagement.getTrains().get(i).getCapacity(); j++)
                {
                    seatList.setText((i + 1) + "\n");
                }
            }
            if(StationManagement.getTrains().get(i).getTrainRoute().getDepartureStation().equals(departStationName) && StationManagement.getTrains().get(i).getTrainRoute().getArrivalStation().equals(destinationStationName))
            {
                break;
            }
        }

    }

    public void onBusinessClassButton()
    {
        passengerTicket.setBusinessClass(MainAdminPageController.businessClass);
        passengerTicket.setEconomyClass(null);
    }
    public void onEconomyClassButton()
    {
        passengerTicket.setEconomyClass(MainAdminPageController.economyClass);
        passengerTicket.setBusinessClass(null);
    }

}
