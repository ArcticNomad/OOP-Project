package com.example.trainManagementProject.backendClasses.Train;

import com.example.trainManagementProject.backendClasses.Ticket.*;

public class BusinessClass
{
    private PassengerSitting businessSiting;
    private int businessCapacity;
    private int seatsAvailable;
    private Facilities facility;

    public BusinessClass(int businessCapacity,Facilities facility)
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

    public Facilities getFacility() {
        return facility;
    }

    public void setFacility(Facilities facility) {
        this.facility = facility;
    }
}
