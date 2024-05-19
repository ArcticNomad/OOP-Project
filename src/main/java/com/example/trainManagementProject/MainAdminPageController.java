package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.Route.Route;
import com.example.trainManagementProject.backendClasses.Route.Schedule;
import com.example.trainManagementProject.backendClasses.Station.Station;
import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import com.example.trainManagementProject.backendClasses.Train.BusinessClass;
import com.example.trainManagementProject.backendClasses.Train.EconomyClass;
import com.example.trainManagementProject.backendClasses.Train.Train;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.util.ArrayList;

public class MainAdminPageController implements Initializable
{


    // STATION DETAILS

    @FXML
    private TextField stationName;
    public TextField stationCity;
    @FXML
    private Button addStationButton ;
    @FXML
    private Button addTrainButton;
    @FXML
    private Button addRouteButton;

    // TRAIN DETAILS
    @FXML
    public TextField trainNumber;
    @FXML
    private TextField trainSpeed;
    @FXML
    private TextField trainCapacity;
    @FXML
    private TextField businessCapacity;
    @FXML
    private TextField businessFacility;
    @FXML
    private TextField economyCapacity;
    @FXML
    private TextField economyFacility;

    // ROUTE DETAILS
    @FXML
    public TextField departStationName;
    @FXML
    private TextField arrivalStationName;

    // ROUTE SCHEDULE DETAILS
    @FXML
    private TextField departDay;
    @FXML
    private TextField departMonth;
    @FXML
    private TextField departYear;
    @FXML
    private TextField arrivalDay;
    @FXML
    private TextField arrivalMonth;
    @FXML
    private TextField arrivalYear;

    @FXML
    private TextField departHour;
    @FXML
    private TextField departMin;
    @FXML
    private TextField arrivalHour;

    @FXML
    private TextField arrivalMin;
    @FXML
    private TextField departAmPm;
    @FXML
    private TextField arrivalAmPm;

    @FXML
    private TextField distanceBwStations;
    @FXML
    private TextField assignRouteText;
    @FXML
    private Button assignRouteButton;
    @FXML
    private TextArea trainNumbers;
    @FXML
    private TextArea stationLists;

    @FXML
    private Button homeButton;
    public void onAddStationButton() throws IOException
    {
       StationManagement.addStation(stationName.getText(),stationCity.getText());
        addStationButton.setText("Added!");
    }

    public static BusinessClass businessClass;
    public static EconomyClass economyClass;

    public void onAddTrainButton()
    {
        Integer businessCap= Integer.valueOf(businessCapacity.getText());
        Integer ecoCap= Integer.valueOf(economyCapacity.getText());
        businessClass =new BusinessClass(businessCap,businessFacility.getText());
        economyClass=new EconomyClass(ecoCap,economyFacility.getText());


        int cap = Integer.parseInt(trainCapacity.getText());
        int num = Integer.parseInt(trainNumber.getText());
        int speed = Integer.parseInt(trainSpeed.getText());
        StationManagement.addTrain(num,speed,cap,businessClass,economyClass);
        addTrainButton.setText("Added!");

    }

    public void onAddRouteButton()
    {

        if (!distanceBwStations.getText().isEmpty()) {
            Route.distanceBetweenStations = Integer.parseInt(distanceBwStations.getText());
        }
        
        // add try catch here
        Station departStation = StationManagement.getStationByName(StationManagement.getStations(),departStationName.getText());
        Station arriveStation = StationManagement.getStationByName(StationManagement.getStations(),arrivalStationName.getText());

        Integer depDay= Integer.valueOf(departDay.getText());
        Integer depYear= Integer.valueOf(departYear.getText());
        Integer arriveDay= Integer.valueOf(arrivalDay.getText());
        Integer arriveYear= Integer.valueOf(arrivalYear.getText());
        Integer depHour= Integer.valueOf(departHour.getText());
        Integer depMin= Integer.valueOf(departMin.getText());
        Integer arriveMin= Integer.valueOf(arrivalMin.getText());
        Integer arriveHour= Integer.valueOf(arrivalHour.getText());


        Schedule schedule =new Schedule(depDay, departMonth.getText(), depYear, arriveDay, arrivalMonth.getText(), arriveYear, depHour, depMin, arriveHour, arriveMin, departAmPm.getText(),arrivalAmPm.getText());

        StationManagement.addRoute(departStation,arriveStation,schedule);

        addRouteButton.setText("Added!");

    }

    public void onAssignRouteButton()
    {
        for (int i = 0; i < StationManagement.getTrains().size(); i++)
        {
            Integer num= Integer.valueOf(assignRouteText.getText());
            if(num.equals(StationManagement.getTrains().get(i).getTrainNUmber()))
            {
                StationManagement.getTrains().get(i).setTrainRoute(StationManagement.getTrainRoute());
                assignRouteButton.setText("Assigned!");
            }
        }
    }
    public void resetStationButton()
    {
        addStationButton.setText("Add Station");
    }
    public void resetTrainButton()
    {
        addTrainButton.setText("Add Train");
    }

    public void resetRouteButton()
    {
        addRouteButton.setText("Add Route");
    }
    public void resetAssignRouteButton()
    {
        assignRouteButton.setText("Assign Route");
    }
    public void onTrainRefreshButton()
    {
        trainNumbers.clear();

        for (int i = 0; i < StationManagement.getTrains().size(); i++) {
            String trainNumb = String.valueOf(StationManagement.getTrains().get(i).getTrainNUmber());
            trainNumbers.appendText("Train " + (i + 1) + " - " + trainNumb + "\n");
        }
    }
    public void onStationRefreshButton()
    {
        stationLists.clear();

        for (int i = 0; i < StationManagement.getStations().size(); i++)
        {
            stationLists.appendText("Station "+(i+1)+" -"+StationManagement.getStations().get(i).getStationName()+"\n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainNumbers.setEditable(false);
        stationLists.setEditable(false);
    }


    public void onHomeButton() throws IOException {
        Stage stage= (Stage) homeButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("selectionScreen.FXML"));

        Scene scene=new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();
    }
}
