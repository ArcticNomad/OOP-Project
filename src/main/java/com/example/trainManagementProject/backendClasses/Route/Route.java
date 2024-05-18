package com.example.trainManagementProject.backendClasses.Route;

import com.example.trainManagementProject.backendClasses.Station.Station;

public class Route
{
  private Schedule trainTiming;
  public static int distanceBetweenStations;

  private Station departureStation;
  private Station arrivalStation;

  public Route(Schedule trainTiming, Station departureStation, Station arrivalStation)
  {
    setArrivalStation(arrivalStation);
    setDepartureStation(departureStation);
    setTrainTiming(trainTiming);
  }
  public Station getDepartureStation() {
    return departureStation;
  }

  public void setDepartureStation(Station departureStation) {
    this.departureStation = departureStation;
  }

  public Station getArrivalStation() {
    return arrivalStation;
  }

  public void setArrivalStation(Station arrivalStation) {
    this.arrivalStation = arrivalStation;
  }

  public Schedule getTrainTiming() {
    return trainTiming;
  }

  public void setTrainTiming(Schedule trainTiming) {
    this.trainTiming = trainTiming;
  }

}
