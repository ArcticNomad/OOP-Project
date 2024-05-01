package StationManagement;

import Passenger.Passenger;
import Route.Route;
import Train.Train;
import Station.Station;
import java.util.ArrayList;
import java.util.Scanner;
public class StationManagement
{
    Scanner input=new Scanner(System.in);
    public static ArrayList<Station> stations=new ArrayList<>();
    ArrayList<Passenger> passengers=new ArrayList<>();
    ArrayList<Route> routes=new ArrayList<>();
    ArrayList<Train> trains=new ArrayList<>();

    public void addStation()
    {
        System.out.println("Enter Station Name :");
        String stationName=input.nextLine();
        System.out.println("Enter Station Location :");
        String location=input.nextLine();


        stations.add(new Station(stationName,location));

    }

    public void removeStation(String stationName)
    {
        for(int i=0;i<stations.size();i++)
        {
            if(stations.get(i).getStationName().equals(stationName))
            {
                stations.remove(i);

                System.out.println("Station Removed !");
            }
        }
    }



    public void displayStations()
    {
        System.out.println("STATION DETAILS");
        System.out.println();
        for(Station s: stations)
        {
            System.out.println("Station Name:"+ s.getStationName());
            System.out.println("Station Location:"+ s.getLocation());

        }
    }

    public void addTrain(int trainNUmber, int trainSpeed, int capacity,Station currentStation, String facilities, int arrivalTime, int departureTime)
    {
        currentStation.addTrain(trainNUmber,trainSpeed,capacity,facilities,arrivalTime,departureTime);
    }



    public void displayFacilities()
    {
        for(Train t: trains)
        {
            System.out.println("Station Facilities :"+ t.getFacilities());
        }
    }


    public void menu()
    {
        System.out.println();
        System.out.println(1+" - Add Station");
        System.out.println(2+" - Remove Station");
        System.out.println(3+" - Display Station");
        System.out.println(4+" - Display Facilities");
        System.out.println(5+" - Add Employee");
        System.out.println(6+" - Display Employees");
        System.out.println(7+" - Remove Employee");
        System.out.println(8+" - Update Employee Role");
        System.out.println(9+" - Add Train");
        System.out.println(10+"- Display Train Details");

    }
}
