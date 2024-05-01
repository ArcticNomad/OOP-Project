package Ticket;

import Route.Route;
import Station.Station;
import Train.Train;

import java.util.Scanner;

public class Ticket extends Train
{
    protected double fare;
    protected double amountPaid;
    Scanner input=new Scanner(System.in);



    public void calculateFare()
    {
        fare=0.5* Route.distanceBetweenStations;
    }
    public void ProcessPayment()
    {
        System.out.println("Amount Due :"+fare);
        System.out.println();
        System.out.println("Enter Payment :");
        double payment=input.nextInt();
        setAmountPaid(payment);

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

    public void setAmountPaid(double amountPaid) {

        if(amountPaid>=fare) {
            this.amountPaid = amountPaid;
        }
        else {
            do {
                System.out.println("Insufficient Funds ! Please Try Again");
                ProcessPayment();
            }while (amountPaid>=fare);
        }
    }
}
