package com.example.trainManagementProject.backendClasses.Route;

public class Schedule {
    private int departDay;
    private String departMonth;
    private int departYear;
    private int arrivalDay;
    private String arrivalMonth;
    private int arrivalYear;

    private int departureHour;
    private int departureMin;
    private int arrivalHour;
    private int arrivalMin;
    private String departure_AM_PM;
    private String arrival_AM_PM;

    private double distanceBwStations;

    public Schedule(int departDay, String departMonth, int departYear, int arrivalDay, String arrivalMonth, int arrivalYear, int departureHour, int departureMin, int arrivalHour, int arrivalMin, String departure_AM_PM, String arrival_AM_PM) {
        setArrivalDay(arrivalDay);
        setArrivalHour(arrivalHour);
        setArrivalMonth(arrivalMonth);
        setArrivalMin(arrivalMin);
        setArrival_AM_PM(arrival_AM_PM);
        setArrivalYear(arrivalYear);

        setDepartDay(departDay);
        setDepartMonth(departMonth);
        setDeparture_AM_PM(departure_AM_PM);
        setDepartMonth(departMonth);
        setDepartYear(departYear);
        setArrivalHour(departureHour);

        setDistanceBwStations(distanceBwStations);
    }


    public String getArrival_AM_PM() {
        return arrival_AM_PM;
    }

    public void setArrival_AM_PM(String arrival_AM_PM) {
        this.arrival_AM_PM = arrival_AM_PM;
    }

    public String getDeparture_AM_PM() {
        return departure_AM_PM;
    }

    public void setDeparture_AM_PM(String departure_AM_PM) {
        this.departure_AM_PM = departure_AM_PM;
    }

    public int getDepartDay() {
        return departDay;
    }

    public void setDepartDay(int departDay) {
        this.departDay = departDay;
    }

    public String getDepartMonth() {
        return departMonth;
    }

    public void setDepartMonth(String departMonth) {
        this.departMonth = departMonth;
    }

    public int getDepartYear() {
        return departYear;
    }

    public void setDepartYear(int departYear) {
        this.departYear = departYear;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(int arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public String getArrivalMonth() {
        return arrivalMonth;
    }

    public void setArrivalMonth(String arrivalMonth) {
        this.arrivalMonth = arrivalMonth;
    }

    public int getArrivalYear() {
        return arrivalYear;
    }

    public void setArrivalYear(int arrivalYear) {
        this.arrivalYear = arrivalYear;
    }

    public int getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(int departureHour) {
        this.departureHour = departureHour;
    }

    public int getDepartureMin() {
        return departureMin;
    }

    public void setDepartureMin(int departureMin) {
        this.departureMin = departureMin;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public int getArrivalMin() {
        return arrivalMin;
    }

    public void setArrivalMin(int arrivalMin) {
        this.arrivalMin = arrivalMin;
    }

    public double getDistanceBwStations() {
        return distanceBwStations;
    }

    public void setDistanceBwStations(double distanceBwStations) {
        this.distanceBwStations = distanceBwStations;
    }
}

