package com.example.trainManagementProject.backendClasses.Train;

import com.example.trainManagementProject.backendClasses.Ticket.*;

public class BusinessClass
{
    private PassengerSitting businessSiting;
    private int businessCapacity;
    private int seatsAvailable;
    private String facility;

    public BusinessClass(int businessCapacity,String facility)
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

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }
}
