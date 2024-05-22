package com.example.trainManagementProject.backendClasses.Train;

public class ClassType
{
    protected int capacity;
    protected int seatsAvailable;
    protected Facilities facility;

    public ClassType(int capacity, int seatsAvailable, Facilities facility) {
        this.capacity = capacity;
        this.seatsAvailable = seatsAvailable;
        this.facility = facility;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
