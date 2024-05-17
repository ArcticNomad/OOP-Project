package com.example.trainmanagementproject;

import com.example.trainmanagementproject.backendClasses.Station.Station;
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
    @FXML
    private TextField stationName;
    public TextField stationCity;
    @FXML
    private Button addStationButton ;
    @FXML
    private Button addTrainButton;
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
