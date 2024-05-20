package com.example.trainManagementProject.backendClasses.Passenger;

import com.example.trainManagementProject.backendClasses.Ticket.*;

import java.util.Scanner;

public class Passenger
{

    private String firstName;
    private String lastName;
    private int age;
    private Long passengerID;
    private static Ticket passengerTicket;

    Scanner input=new Scanner(System.in);



    public Passenger(Long passengerID, String firstName, String lastName, int age, Ticket passengerTicket)
    {
        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setPassengerID(passengerID);
        setPassengerTicket(passengerTicket);
    }

    public Passenger(){}

    public Passenger(Long id, String firstName, String lastName, int age)
    {
        setAge(age);
        setPassengerID(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void assignTicket(){}

    public void menu()
    {
        System.out.println(1+" - Buy Ticket ");
        System.out.println(2+" - Display Passenger Details ");
        System.out.println(3+" - Pay for Ticket ");
        System.out.println(4+" - Feedback ");
    }

    public Long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Long passengerID) {
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
