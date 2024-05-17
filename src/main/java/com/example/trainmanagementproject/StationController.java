package com.example.trainmanagementproject;

import com.example.trainmanagementproject.backendClasses.StationManagement.StationManagement;
import com.example.trainmanagementproject.backendClasses.Station.Station;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StationController
{
    private ArrayList<Station>stations=new ArrayList<>();
    private TextField stationName;
    private TextField stationCity;


    public void onAddStationButton()
    {
            stations.add(new Station(stationName.getText(),stationCity.getText()));
    }
}
