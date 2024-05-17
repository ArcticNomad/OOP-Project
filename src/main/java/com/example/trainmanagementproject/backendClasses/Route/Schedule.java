package com.example.trainmanagementproject.backendClasses.Route;

import com.example.trainmanagementproject.backendClasses.Station.Station;

import java.util.Stack;

public class Schedule
{
    private String month;
    private int day;
    private int departureTiming;
    private int arrivalTiming;
    private String departure_AM_PM;
    private String arrival_AM_PM;


    public Schedule(String month,int day,int departureTiming, int arrivalTiming, String departure_AM_PM, String arrival_AM_PM)
    {
        setDay(day);
        setMonth(month);
        setDepartureTiming(departureTiming);
        setArrivalTiming(arrivalTiming);
        setArrival_AM_PM(arrival_AM_PM);
        setDeparture_AM_PM(departure_AM_PM);
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDepartureTiming() {
        return departureTiming;
    }

    public void setDepartureTiming(int departureTiming) {
        this.departureTiming = departureTiming;
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

    public int getArrivalTiming() {
        return arrivalTiming;
    }

    public void setArrivalTiming(int arrivalTiming) {
        this.arrivalTiming = arrivalTiming;
    }
}
