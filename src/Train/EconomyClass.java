package Train;

import Ticket.PassengerSitting;
import java.util.ArrayList;

public class EconomyClass
{
    private PassengerSitting EconomySiting;
    private int economyCapacity;
    private int seatsAvailable;
    private ArrayList<String> facility;

    public EconomyClass(int economyCapacity,ArrayList<String> facility)
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

    public ArrayList<String> getFacility() {
        return facility;
    }

    public void setFacility(ArrayList<String> facility) {
        this.facility = facility;
    }

}
