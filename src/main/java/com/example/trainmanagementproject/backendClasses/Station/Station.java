package com.example.trainmanagementproject.backendClasses.Station;

import com.example.trainmanagementproject.backendClasses.Route.*;
import com.example.trainmanagementproject.backendClasses.StationManagement.*;
import com.example.trainmanagementproject.backendClasses.Train.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Station
{
  private String stationName;
  private String city;
  ArrayList<Train> trains = new ArrayList<>();


  Scanner input = new Scanner(System.in);

  public Station(String stationName, String city) {
    setStationName(stationName);
    setCity(city);
  }


  public void addTrain(int trainNUmber, int trainSpeed, int capacity, BusinessClass businessClass,EconomyClass economyClass) {
    trains.add(new Train(trainNUmber, trainSpeed, capacity,businessClass,economyClass));
  }


  public void removeTrain()
  {
    System.out.println("Enter Train Number :");
    int trainNum=input.nextInt();

    for (int i=0;i<trains.size();i++)
    {
      if(trainNum==trains.get(i).getTrainNUmber())
      {
        trains.remove(i);
      }
    }

  }

  public void displayStationDetails()
  {

  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


}