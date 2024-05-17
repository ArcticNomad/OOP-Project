package com.example.trainmanagementproject.backendClasses.Ticket;

import com.example.trainmanagementproject.backendClasses.Passenger.*;
import com.example.trainmanagementproject.backendClasses.Route.*;
import com.example.trainmanagementproject.backendClasses.Station.*;
import com.example.trainmanagementproject.backendClasses.Train.*;

import java.util.Scanner;

public class Ticket
{
    private double fare;
    private double amountPaid;
    Train ticketTrain;
    private PassengerSitting passengerSeat;
    private Passenger passenger;
    private BusinessClass businessClass;
    private EconomyClass economyClass;


    Scanner input=new Scanner(System.in);



    public void displayTicket()
    {
        System.out.println("Ticket Details :");
        System.out.println();
        System.out.println("Departure Time :"+ticketTrain.getTrainRoute().getTrainTiming().getDepartureTiming()+" "+ticketTrain.getTrainRoute().getTrainTiming().getDeparture_AM_PM());
        System.out.println("Arrival Time :"+ticketTrain.getTrainRoute().getTrainTiming().getArrivalTiming()+" "+ticketTrain.getTrainRoute().getTrainTiming().getArrival_AM_PM());
        System.out.println("Departure Station :" +ticketTrain.getTrainRoute().getDepartureStation().getStationName()+" "+ticketTrain.getTrainRoute().getDepartureStation().getCity());
        System.out.println("Arrival Station :" +ticketTrain.getTrainRoute().getArrivalStation().getStationName()+" "+ticketTrain.getTrainRoute().getArrivalStation().getCity());
        System.out.println("Train Number :" +ticketTrain.getTrainNUmber());
        System.out.println("Ticket Price :" +getFare());
        System.out.println();
        System.out.println("Passenger Seat Details :");
        System.out.println();
        System.out.println("Seat Number :"+getPassengerSeat().getSeatNo());
        System.out.println("Cabin Number :"+getPassengerSeat().getCabin());
        System.out.println("Carriage Number :"+getPassengerSeat().getCarriageNo());
    }

    public void generatePassengerSeat()
    {
        System.out.println("Enter Seat Number :");
        int seat=input.nextInt();
        System.out.println("Enter Cabin Number :");
        int cabin=input.nextInt();
        System.out.println("Enter Carriage Number ");
        int carriage=input.nextInt();

        PassengerSitting sitting=new PassengerSitting(seat,cabin,carriage);

        setPassengerSeat(sitting);

    }


    public void calculateFare()
    {
        fare=2* Route.distanceBetweenStations;
    }
    public void ProcessPayment()
    {
        System.out.println("Amount Due :"+fare);
        System.out.println();
        System.out.println("Enter Payment :");
        double payment=input.nextInt();
        setAmountPaid(payment);

    }

    public void setAmountPaid(double amountPaid) {

        if(amountPaid>=fare) {
            this.amountPaid = amountPaid;
            double change=amountPaid-fare;
            System.out.println("Change :"+change);
        }
        else {
            System.out.println("Insufficient Funds ! Please Try Again");
        }
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public PassengerSitting getPassengerSeat() {
        return passengerSeat;
    }

    public void setPassengerSeat(PassengerSitting passengerSeat) {
        this.passengerSeat = passengerSeat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public BusinessClass getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(BusinessClass businessClass) {
        this.businessClass = businessClass;
    }

    public EconomyClass getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(EconomyClass economyClass) {
        this.economyClass = economyClass;
    }

    public Train getTicketTrain() {
        return ticketTrain;
    }

    public void setTicketTrain(Train ticketTrain) {
        this.ticketTrain = ticketTrain;
    }
}
