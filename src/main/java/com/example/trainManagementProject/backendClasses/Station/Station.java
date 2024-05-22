package com.example.trainManagementProject.backendClasses.Station;

import com.example.trainManagementProject.backendClasses.Train.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Station
{
  private String stationName;
  private Cities city;
  ArrayList<Train> trains = new ArrayList<>();


  Scanner input = new Scanner(System.in);

  public Station(String stationName, Cities city) {
    setStationName(stationName);
    setCity(city);
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

  public Cities getCity() {
    return city;
  }

  public void setCity(Cities city) {
    this.city = city;
  }


}