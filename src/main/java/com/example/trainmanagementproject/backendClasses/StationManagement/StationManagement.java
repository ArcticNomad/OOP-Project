package com.example.trainmanagementproject.backendClasses.StationManagement;

import com.example.trainmanagementproject.backendClasses.Passenger.*;
import com.example.trainmanagementproject.backendClasses.Route.*;
import com.example.trainmanagementproject.backendClasses.Ticket.*;
import com.example.trainmanagementproject.backendClasses.Train.*;
import com.example.trainmanagementproject.backendClasses.Station.*;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class StationManagement
{
    Scanner input=new Scanner(System.in);
    ArrayList<Station> stations=new ArrayList<>();
    ArrayList<Passenger> passengers=new ArrayList<>();
    ArrayList<Route> routes=new ArrayList<>();
    ArrayList<Train> trains=new ArrayList<>();

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public void addPassenger(int cnic, String firstName, String lastName, int age,Ticket passengerTicket)
    {
        passengers.add(new Passenger(cnic,firstName,lastName,age,passengerTicket));
    }
    public int getPassengerByDetails(int cnic)
    {
        for (int i = 0; i < passengers.size(); i++)
        {
            if (cnic==passengers.get(i).getPassengerID())
            {
                return i;
            }
        }
        return 0;
    }


    public void displayPassengerDetails()
    {
        System.out.println("Enter Passenger First Name :");
        String firstName=input.nextLine();
        System.out.println("Enter Passenger Last Name :");
        String lastName=input.nextLine();

        for (int i = 0; i < passengers.size(); i++)
        {
            if(passengers.get(i).getFirstName().equals(firstName) && passengers.get(i).getLastName().equals(lastName)) {
                System.out.println("Passenger Details :");
                System.out.println();
                System.out.println("Name :" + passengers.get(i).getFirstName()+" "+passengers.get(i).getLastName());
                System.out.println("Age :" + passengers.get(i).getAge());
                System.out.println("ID :" + passengers.get(i).getPassengerID());
                System.out.println();
                System.out.println("Passenger Ticket Details :");
                System.out.println();
                passengers.get(i).getPassengerTicket().displayTicket();

            }
        }
    }

    public void addStation(String stationName, String city)
    {

        stations.add(new Station(stationName,city));

    }

    public Station getStationByName(String stationName) {
        for(int i = 0; i < stations.size(); i++)
        {
            if (stations.get(i).getStationName().equals(stationName))
            {
                return stations.get(i); // Return the station if a match is found
            }
        }
        // If no match found, display error message and return null
        System.out.println("Incorrect Station Entered !");
        return null;
    }


    public void removeStation(String stationName)
    {
        if (stations.isEmpty())
        {
            System.out.println("No Stations Added ! Please Add Stations First");
        }
        else {
            for (int i = 0; i < stations.size(); i++) {
                if (stations.get(i).getStationName().equals(stationName)) {
                    stations.remove(i);

                    System.out.println("Station Removed !");
                }
            }
        }
    }



    public void displayStations()
    {
        System.out.println("STATION DETAILS");
        System.out.println();
        if(stations.isEmpty())
        {
            System.out.println("No Stations Added ! Please Add Stations First");
            System.out.println();
        }
        else {
            for (int i = 0; i < stations.size(); i++) {
                System.out.println("Station Name:" + stations.get(i).getStationName());
                System.out.println("Station Location:" + stations.get(i).getCity());
            }
        }
    }

    public void addTrain(int trainNUmber, int trainSpeed, int capacity,BusinessClass businessClass,EconomyClass economyClass)
    {
        trains.add(new Train(trainNUmber,trainSpeed,capacity,businessClass,economyClass));
    }

    public void displayTrainDetails()
    {
        if(trains.isEmpty())
        {
            System.out.println("No Trains Have Been Added !");
        }
        else
        {
            System.out.println("Train Details ");
            System.out.println();

            for (int i = 0; i < trains.size(); i++) {
                System.out.println("Train " + (i + 1));
                System.out.println("Train Number :" + getTrains().get(i).getTrainNUmber());
                System.out.println("Train Capacity :" + getTrains().get(i).getCapacity());
                System.out.println("Train Speed :" + getTrains().get(i).getTrainSpeed());
                System.out.println("Business Class Capacity :" + getTrains().get(i).getBusinessClass().getBusinessCapacity());
                System.out.println("Economy Class Capacity :" + getTrains().get(i).getEconomyClass().getEconomyCapacity());
            }
        }
    }

    public void displayFacilities() {
        if (trains.isEmpty()) {
            System.out.println("No Train Added ! Please Add Trains First ");
        } else {
            for (Train t : trains) {
                System.out.println("Business Class Facilities :" + t.getBusinessClass().getFacility());
                System.out.println("Economy Class Facilities :" + t.getEconomyClass().getFacility());
            }
        }
    }


    public void menu()
    {
        System.out.println();
        System.out.println(1+" - Add Station");
        System.out.println(2+" - Remove Station");
        System.out.println(3+" - Display Station");
        System.out.println(4+" - Display Train Facilities");
        System.out.println(5+" - Add Employee");
        System.out.println(6+" - Display Employees");
        System.out.println(7+" - Remove Employee");
        System.out.println(8+" - Update Employee Role");
        System.out.println(9+" - Add Train");
        System.out.println(10+"- Display Train Details");
        System.out.println(11+"- Add Train Schedule");
        System.out.println(12+"- Assign Schedule to Train");


    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
