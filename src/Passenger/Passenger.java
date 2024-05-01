package Passenger;

import Station.Station;
import StationManagement.StationManagement;
import Ticket.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger
{

    Scanner input=new Scanner(System.in);
    private int passengerID;
    private String name;
    private int age;

    private Ticket passengerTicket;

    ArrayList<Passenger>passengers=new ArrayList<>();

    public Passenger(int passengerID,String name,int age, Ticket passengerTicket)
    {
        setAge(age);
        setName(name);
        setPassengerID(passengerID);
        setPassengerTicket(passengerTicket);
    }

    public Passenger
            (){}

   public void displayPassengerDetails()
   {
       for (int i = 0; i < passengers.size(); i++)
       {

           System.out.println("Passenger Details :");
           System.out.println();
           System.out.println("Name :" + passengers.get(i).getName());
           System.out.println("Age :" + passengers.get(i).getAge());
           System.out.println("ID :" + passengers.get(i).getPassengerID());
           System.out.println();
           System.out.println("Passenger Ticket Details :");
           System.out.println();
           System.out.println("Departure Time :" + passengerTicket.getDepartureTime());
           System.out.println("Departure Station :" + passengerTicket.getCurrentStation());
           System.out.println("Arrival Station :" + passengerTicket.getDestinationStation());
           System.out.println("Ticket Price :" + passengerTicket.getFare());
           System.out.println("Train Number :" + passengerTicket.getTrainNUmber());
       }
   }

    public void addPassenger(Ticket passengerTicket)
    {
        System.out.println("Enter Passenger Name:");
        String name= input.nextLine();
        System.out.println("Enter CNIC Number:");
        int cnic=input.nextInt();
        System.out.println("Enter Age:");
        int age= input.nextInt();

        passengers.add(new Passenger(cnic,name,age,passengerTicket));
    }
    public void menu()
    {
        System.out.println(1+" - Buy Ticket ");
        System.out.println(2+" - Display Passenger Details ");
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Ticket getPassengerTicket() {
        return passengerTicket;
    }

    public void setPassengerTicket(Ticket passengerTicket) {
        this.passengerTicket = passengerTicket;
    }
}
