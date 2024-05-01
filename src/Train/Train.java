package Train;

import Station.Station;
import StationManagement.StationManagement;

import java.util.Scanner;

public class Train extends Station
{
  private int trainNUmber;
  private int trainSpeed;
  private int capacity;
  private String facilities;
  int departureTime;
  int arrivalTime;


  Scanner input=new Scanner(System.in);

  //Schedule trainSchedule;

  public Train(int trainNUmber, int trainSpeed, int capacity,String facilities,int arrivalTime, int departureTime)
  {
    setCapacity(capacity);
    setTrainSpeed(trainSpeed);
    setTrainNUmber(trainNUmber);
    setFacilities(facilities);
    setArrivalTime(arrivalTime);
    setDepartureTime(departureTime);
  }

  public Train(){}


  public int getTrainNUmber() {
    return trainNUmber;
  }

  public void setTrainNUmber(int trainNUmber) {
    this.trainNUmber = trainNUmber;
  }

  public int getTrainSpeed() {
    return trainSpeed;
  }

  public void setTrainSpeed(int trainSpeed) {
    this.trainSpeed = trainSpeed;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }


  public String getFacilities() {
    return facilities;
  }

  public void setFacilities(String facilities) {
    this.facilities = facilities;
  }


  public int getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(int departureTime) {
    this.departureTime = departureTime;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public void displayTrainDetails() {

    System.out.println("train number :" + trainNUmber);
    System.out.println("train speed :" + trainSpeed);
    System.out.println("capacity :" + capacity);
    System.out.println("facilities :"+facilities);
    System.out.println("departure time : "+departureTime);
    System.out.println("arrival time :"+arrivalTime);
  }
}