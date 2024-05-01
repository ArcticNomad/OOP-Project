package Station;

import StationManagement.StationManagement;
import Train.Train;
import java.util.ArrayList;
import java.util.Scanner;

public class Station
{
  private String stationName;
  private String location;
  protected Station currentStation;
  protected Station destinationStation;


  Scanner input=new Scanner(System.in);
  ArrayList<Train> trains=new ArrayList<>();

  public Station(String stationName,String location)

  {
    setStationName(stationName);
    setLocation(location);
  }

  public Station(){}

  public void addTrain(int trainNUmber, int trainSpeed, int capacity, String facilities,int arrivalTime,int departureTime)
  {
    trains.add(new Train(trainNUmber,trainSpeed,capacity,facilities,arrivalTime,departureTime));
  }

  public void buyTicket(int departIndex)
  {
    /*System.out.println("Select Departure Location :");
    System.out.println();
    for (int i = 0; i < StationManagement.stations.size(); i++)
    {
      System.out.println((i+1)+"-  "+"Station Location :"+StationManagement.stations.get(i).getLocation());
      System.out.println();
    }
    int departChoice=input.nextInt();
    int departIndex=departChoice-1;*/

    System.out.println("Select Destination Location :");
    System.out.println();
    for (int i = 0; i < StationManagement.stations.size(); i++)
    {
      System.out.println((i+1)+"-  "+"Station Location :"+StationManagement.stations.get(i).getLocation());
      System.out.println();
    }
    int arrivalChoice=input.nextInt();
    int arrivalIndex=arrivalChoice-1;

    setCurrentStation(StationManagement.stations.get(departIndex));
    setDestinationStation(StationManagement.stations.get(arrivalIndex));


  }
  public void removeTrain()
  {

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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public Station getCurrentStation() {
    return currentStation;
  }

  public void setCurrentStation(Station currentStation) {
    this.currentStation = currentStation;
  }

  public Station getDestinationStation() {
    return destinationStation;
  }

  public void setDestinationStation(Station destinationStation) {
    this.destinationStation = destinationStation;
  }
}