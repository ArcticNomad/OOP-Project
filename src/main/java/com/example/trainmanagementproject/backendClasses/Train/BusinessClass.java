package com.example.trainmanagementproject.backendClasses.Train;

import com.example.trainmanagementproject.backendClasses.Ticket.*;
import java.util.ArrayList;

public class BusinessClass
{
    private PassengerSitting businessSiting;
    private int businessCapacity;
    private int seatsAvailable;
    private ArrayList<String>facility;

    public BusinessClass(int businessCapacity,ArrayList<String> facility)
    {
        setBusinessCapacity(seatsAvailable);
        setBusinessCapacity(businessCapacity);
        setFacility(facility);
    }

    public int getBusinessCapacity() {
        return businessCapacity;
    }

    public void setBusinessCapacity(int businessCapacity) {
        this.businessCapacity = businessCapacity;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public ArrayList<String> getFacility() {
        return facility;
    }

    public void setFacility(ArrayList<String> facility) {
        this.facility = facility;
    }
}
