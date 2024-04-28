package Station;

import java.util.ArrayList;
import Train.Train;

public class Station
{
    private String stationName;
    private String location;
    private String facilities;

    ArrayList<Train> trains=new ArrayList<>();

    public Station(String stationName,String location,String facilities)

    {
        setStationName(stationName);
        setFacilities(facilities);
        setLocation(location);
    }

    public void addTrain(int trainNUmber, int trainSpeed, int capacity)
    {
        trains.add(new Train(trainNUmber,trainSpeed,capacity));
    }
    public void removeTrain()
    {

    }
    public void displayStationDetails()
    {

    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
