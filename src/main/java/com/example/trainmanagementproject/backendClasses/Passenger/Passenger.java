package com.example.trainmanagementproject.backendClasses.Passenger;

import com.example.trainmanagementproject.backendClasses.Station.Station;
import com.example.trainmanagementproject.backendClasses.StationManagement.StationManagement;
import com.example.trainmanagementproject.backendClasses.Ticket.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger
{

    private String firstName;
    private String lastName;
    private int age;
    private int passengerID;
    private Ticket passengerTicket;

    Scanner input=new Scanner(System.in);



    public Passenger(int passengerID,String firstName,String lastName, int age, Ticket passengerTicket)
    {
        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setPassengerID(passengerID);
        setPassengerTicket(passengerTicket);
    }

    public Passenger(){}

    public void assignTicket(){}

    public void menu()
    {
        System.out.println(1+" - Buy Ticket ");
        System.out.println(2+" - Display Passenger Details ");
        System.out.println(3+" - Pay for Ticket ");
        System.out.println(4+" - Feedback ");
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
