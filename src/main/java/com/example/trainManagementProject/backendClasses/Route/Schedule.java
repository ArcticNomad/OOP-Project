package com.example.trainManagementProject.backendClasses.Route;

public class Schedule {
    private Days departDay;
    private Months departMonth;
    private int departYear;
    private Days arrivalDay;
    private Months arrivalMonth;
    private int arrivalYear;

    private int departureHour;
    private int departureMin;
    private int arrivalHour;
    private int arrivalMin;
    private Timing departure_AM_PM;
    private Timing arrival_AM_PM;

    private double distanceBwStations;

    public Schedule(Days departDay, Months departMonth, int departYear, Days arrivalDay, Months arrivalMonth, int arrivalYear, int departureHour, int departureMin, int arrivalHour, int arrivalMin, Timing departure_AM_PM, Timing arrival_AM_PM) {
        setArrivalDay(arrivalDay);
        setArrivalHour(arrivalHour);
        setArrivalMonth(arrivalMonth);
        setArrivalMin(arrivalMin);
        setDepartureMin(departureMin);
        setArrival_AM_PM(arrival_AM_PM);
        setArrivalYear(arrivalYear);

        setDepartDay(departDay);
        setDepartMonth(departMonth);
        setDeparture_AM_PM(departure_AM_PM);
        setDepartMonth(departMonth);
        setDepartYear(departYear);
        setArrivalHour(arrivalHour);
        setDepartureHour(departureHour);

        setDistanceBwStations(distanceBwStations);
    }


    public Timing getArrival_AM_PM() {
        return arrival_AM_PM;
    }

    public void setArrival_AM_PM(Timing arrival_AM_PM) {
        this.arrival_AM_PM = arrival_AM_PM;
    }

    public Timing getDeparture_AM_PM() {
        return departure_AM_PM;
    }

    public void setDeparture_AM_PM(Timing departure_AM_PM) {
        this.departure_AM_PM = departure_AM_PM;
    }

    public Days getDepartDay() {
        return departDay;
    }

    public void setDepartDay(Days departDay) {
        this.departDay = departDay;
    }

    public Months getDepartMonth() {
        return departMonth;
    }

    public void setDepartMonth(Months departMonth) {
        this.departMonth = departMonth;
    }

    public int getDepartYear() {
        return departYear;
    }

    public void setDepartYear(int departYear) {
        this.departYear = departYear;
    }

    public Days getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(Days arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public Months getArrivalMonth() {
        return arrivalMonth;
    }

    public void setArrivalMonth(Months arrivalMonth) {
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

