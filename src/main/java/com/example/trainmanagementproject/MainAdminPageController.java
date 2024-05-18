package com.example.trainmanagementproject;

import com.example.trainmanagementproject.backendClasses.Route.Route;
import com.example.trainmanagementproject.backendClasses.Route.Schedule;
import com.example.trainmanagementproject.backendClasses.Station.Station;
import com.example.trainmanagementproject.backendClasses.StationManagement.StationManagement;
import com.example.trainmanagementproject.backendClasses.Train.BusinessClass;
import com.example.trainmanagementproject.backendClasses.Train.EconomyClass;
import com.example.trainmanagementproject.backendClasses.Train.Train;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainAdminPageController
{

    private ArrayList<Station> stations=new ArrayList<>();
    private ArrayList<Train> trains=new ArrayList<>();
    private ArrayList<Route> routes=new ArrayList<>();

    // STATION DETAILS

    @FXML
    private TextField stationName;
    public TextField stationCity;
    @FXML
    private Button addStationButton ;
    @FXML
    private Button addTrainButton;
    private Button addRouteButton;

    // TRAIN DETAILS
    @FXML
    public TextField trainNumber;
    @FXML
    private TextField trainSpeed;
    @FXML
    public TextField trainCapacity;
    public TextField businessCapacity;
    public TextField businessFacility;
    public TextField economyCapacity;
    public TextField economyFacility;

    // ROUTE DETAILS
    @FXML
    public TextField departStationName;
    public TextField arrivalStationName;

    // ROUTE SCHEDULE DETAILS
    public TextField departDay;
    public TextField departMonth;
    public TextField departYear;
    public TextField arrivalDay;
    public TextField arrivalMonth;
    public TextField arrivalYear;

    public TextField departHour;
    public TextField departMin;
    public TextField arrivalHour;

    public TextField arrivalMin;
    public TextField departAmPm;
    public TextField arrivalAmPm;

    public TextField distanceBwStations;


    public void onAddStationButton() throws IOException
    {
        stations.add(new Station(stationName.getText(),stationCity.getText()));
        addStationButton.setText("Added!");
    }
    public void onAddTrainButton()
    {
        Integer businessCap= Integer.valueOf(businessCapacity.getText());
        Integer ecoCap= Integer.valueOf(economyCapacity.getText());
        BusinessClass businessClass=new BusinessClass(businessCap,businessFacility.getText());
        EconomyClass economyClass=new EconomyClass(ecoCap,economyFacility.getText());


        int cap = Integer.parseInt(trainCapacity.getText());
        int num = Integer.parseInt(trainNumber.getText());
        int speed = Integer.parseInt(trainSpeed.getText());
        trains.add(new Train(num,speed,cap,businessClass,economyClass));
        addTrainButton.setText("Added!");

    }

    public void onAddRouteButton()
    {
        // add try catch here
        Station departStation = StationManagement.getStationByName(departStationName.getText());
        Station arriveStation = StationManagement.getStationByName(arrivalStationName.getText());

        Integer depDay= Integer.valueOf(departDay.getText());
        Integer depYear= Integer.valueOf(departYear.getText());
        Integer arriveDay= Integer.valueOf(arrivalDay.getText());
        Integer arriveYear= Integer.valueOf(arrivalYear.getText());
        Integer depHour= Integer.valueOf(departHour.getText());
        Integer depMin= Integer.valueOf(departMin.getText());
        Integer arriveMin= Integer.valueOf(arrivalMin.getText());
        Integer arriveHour= Integer.valueOf(arrivalHour.getText());

        Schedule schedule =new Schedule(depDay, departMonth.getText(), depYear, arriveDay, arrivalMonth.getText(), arriveYear, depHour, depMin, arriveHour, arriveMin, departAmPm.getText(),arrivalAmPm.getText());
        routes.add(new Route(schedule, departStation,arriveStation));
    }
    public void resetStationButton()
    {
        addStationButton.setText("Add Station");
    }
    public void resetTrainButton()
    {
        addStationButton.setText("Add Train");
    }

}
