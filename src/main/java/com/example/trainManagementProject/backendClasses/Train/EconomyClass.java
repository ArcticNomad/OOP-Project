package com.example.trainManagementProject.backendClasses.Train;

import com.example.trainManagementProject.backendClasses.Ticket.*;

public class EconomyClass
{
    private PassengerSitting EconomySiting;
    private int economyCapacity;
    private int seatsAvailable;
    private String facility;

    public EconomyClass(int economyCapacity,String facility)
    {
        setFacility(facility);
        setEconomyCapacity(economyCapacity);
        setSeatsAvailable(seatsAvailable);
    }

    public int getEconomyCapacity() {
        return economyCapacity;
    }

    public void setEconomyCapacity(int economyCapacity) {
        this.economyCapacity = economyCapacity;
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
