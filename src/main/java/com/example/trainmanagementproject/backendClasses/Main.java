package com.example.trainmanagementproject.backendClasses;

import com.example.trainmanagementproject.backendClasses.EmployeeManagement.*;
import com.example.trainmanagementproject.backendClasses.Feedback.Feedback;
import com.example.trainmanagementproject.backendClasses.Passenger.Passenger;
import com.example.trainmanagementproject.backendClasses.Route.*;
import com.example.trainmanagementproject.backendClasses.StationManagement.StationManagement;
import com.example.trainmanagementproject.backendClasses.Station.Station;
import com.example.trainmanagementproject.backendClasses.Ticket.Ticket;
import com.example.trainmanagementproject.backendClasses.Train.*;


import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        StationManagement manager = new StationManagement();
        EmployeeManagement employeeManager = new EmployeeManagement();
        Passenger passenger = new Passenger();
        Route trainRoute = null;
        Schedule trainTiming;
        Ticket passengerTicket = null;
        BusinessClass businessClass = null;
        EconomyClass economyClass = null;
        int trainNumber = 0;
        int remainingSeats = 0;

        BufferedWriter stationWriter;
        BufferedWriter employeeWriter;
        BufferedWriter trainWriter;
        BufferedWriter routeWriter;
        BufferedWriter passengerWriter;
        BufferedReader trainRead;


        try {
            stationWriter = new BufferedWriter(new FileWriter("Stations.txt",true));
            employeeWriter=new BufferedWriter(new FileWriter("Employees.txt",true));
            trainWriter=new BufferedWriter(new FileWriter("Train.txt",true));
            routeWriter=new BufferedWriter(new FileWriter("Routes.txt",true));
            passengerWriter=new BufferedWriter(new FileWriter("Passenger.txt",true));
            trainRead=new BufferedReader(new FileReader("Train.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int choice = 0;
        int option = 0;
        do {
            System.out.println("Enter Authentication (admin or pass):");
            String authentication = input.nextLine();
            if (authentication.equals("admin")) {
                manager.menu();
                choice = input.nextInt();
                input.nextLine(); // consume newline character
                if (choice == 1) {

                    System.out.println("Enter Station Name :");
                    String stationName = input.nextLine();
                    System.out.println("Enter Station City :");
                    String city = input.nextLine();
                    manager.addStation(stationName, city);

                    try {
                        stationWriter.write("Station Name :"+stationName);
                        stationWriter.newLine();
                        stationWriter.write("City :"+city);
                        stationWriter.newLine();
                        stationWriter.flush();
                        System.out.println("Station Added !");

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else if (choice == 2) {
                    System.out.println("Enter Name of Station to Be Removed:");
                    String station = input.nextLine();
                    manager.removeStation(station);
                } else if (choice == 3) {
                    manager.displayStations();
                } else if (choice == 4) {
                    manager.displayFacilities();
                } else if (choice == 5) {
                    System.out.println("Enter Employee ID :");
                    int ID=input.nextInt();
                    System.out.println("Enter Employee Name :");
                    input.nextLine();
                    String name=input.nextLine();
                    System.out.println("Enter Employee Role :");
                    String role=input.nextLine();

                    employeeManager.addEmployee(ID,name,role);

                    try {
                        employeeWriter.write("Employee ID :"+ID);
                        employeeWriter.newLine();
                        employeeWriter.write("Employee name :"+name);
                        employeeWriter.newLine();
                        employeeWriter.write("Employee Role :"+role);
                        employeeWriter.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else if (choice == 6) {
                    employeeManager.displayEmployees();
                } else if (choice == 7) {
                    System.out.println("Enter Employee ID:");
                    int id = input.nextInt();
                    employeeManager.removeEmployee(id);
                } else if (choice == 8) {
                    System.out.println("Enter Role:");
                    input.nextLine(); // consume newline character
                    String role = input.nextLine();
                    System.out.println("Enter ID:");
                    int id = input.nextInt();
                    employeeManager.updateRoles(role, id);



                } else if (choice == 9) {
                    System.out.println("Enter Train Number:");
                    int trainNum = input.nextInt();
                    System.out.println("Enter Train Speed (KM/H):");
                    int speed = input.nextInt();
                    System.out.println("Enter Train Capacity:");
                    int capacity = input.nextInt();
                    input.nextLine(); // consume newline character
                    System.out.println("Enter Business Class Capacity:");
                    int businessCapacity = input.nextInt();
                    input.nextLine(); // consume newline character
                    System.out.println("Enter Business Class facilities");
                    System.out.println("How Many Would You Like To Add?");
                    int num = input.nextInt();
                    input.nextLine(); // consume newline character
                    ArrayList<String> businessFacilities = new ArrayList<>();
                    for (int i = 0; i < num; i++) {
                        System.out.println("Enter Facility Name :");
                        String facility = input.nextLine();
                        businessFacilities.add(facility);
                    }
                    System.out.println("Enter Economy Class Capacity:");
                    int economCapacity = input.nextInt();
                    input.nextLine(); // consume newline character
                    System.out.println("Enter Economy Class facilities");
                    System.out.println("How Many Would You Like To Add?");
                    int num2 = input.nextInt();
                    input.nextLine(); // consume newline character

                    ArrayList<String> economyFacility = new ArrayList<>();
                    for (int i = 0; i < num2; i++) {
                        String facility = input.nextLine();
                        economyFacility.add(facility);
                    }

                    //businessClass = new BusinessClass(businessCapacity, businessFacilities);
                    //economyClass = new EconomyClass(economCapacity, economyFacility);

                    try {
                        manager.addTrain(trainNum, speed, capacity, businessClass, economyClass);
                        System.out.println("Train added Successfully");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    remainingSeats = capacity;
                    for (int i = 0; i < manager.getTrains().size(); i++) {
                        if (trainNum == manager.getTrains().get(i).getTrainNUmber()) {
                            manager.getTrains().get(i).setRemainingSeats(capacity);
                        }
                    }

                        try {

                            trainWriter.write("Train Number :"+trainNum);
                            trainWriter.newLine();
                            trainWriter.write("Train Capacity :"+capacity);
                            trainWriter.newLine();
                            trainWriter.write("Train Speed :"+speed);
                            trainWriter.newLine();
                            trainWriter.write("Business Class Capacity :"+businessCapacity);
                            trainWriter.newLine();
                            trainWriter.write("Business Class Facilities :"+businessFacilities);
                            trainWriter.newLine();
                            trainWriter.write("Economy Class Capacity :"+economCapacity);
                            trainWriter.newLine();
                            trainWriter.write("Economy Class Facilities :"+economyFacility);
                            trainWriter.newLine();
                            trainWriter.flush();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }





                } else if (choice == 10) {
                    manager.displayTrainDetails();
                } else if (choice == 11) {
                    System.out.println("Enter Departure Station :");
                    String departureStation = input.nextLine();
                    System.out.println("Enter Arrival Station :");
                    String arrivalStation = input.nextLine();
                    System.out.println("Enter Departure Day (In Number):");
                    int day = input.nextInt();
                    System.out.println("Enter Departure Month (In Alphabets):");
                    String month = input.next();
                    System.out.println("Enter Departure Timing:");
                    int departTime = input.nextInt();
                    System.out.println("Enter AM/PM:");
                    String departure_AM_PM = input.next();
                    System.out.println("Enter Arrival Timing:");
                    int arrivalTime = input.nextInt();
                    System.out.println("Enter AM/PM:");
                    String arrival_AM_PM = input.next();

                    Station departStation = manager.getStationByName(departureStation);
                    Station arriveStation = manager.getStationByName(arrivalStation);

                    trainTiming = new Schedule(month, day, departTime, arrivalTime, departure_AM_PM, arrival_AM_PM);
                    trainRoute = new Route(trainTiming, departStation, arriveStation);

                    try {
                        routeWriter.write("Departure Station :"+departStation);
                        routeWriter.write("Arrival Station :"+arrivalStation);
                        routeWriter.write("Departure Day :"+day);
                        routeWriter.write("Departure Month :"+month);
                        routeWriter.write("Departure Timing :"+departure_AM_PM+" "+departure_AM_PM);
                        routeWriter.write("Arrival Timing :"+arrivalTime+" "+arrival_AM_PM);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else if (choice == 12) {

                    boolean stationAssign = false;
                    System.out.println("Enter Train Number:");
                    trainNumber = input.nextInt();
                    for (int i = 0; i < manager.getTrains().size(); i++) {
                        if (trainNumber == manager.getTrains().get(i).getTrainNUmber()) {
                            stationAssign = true;
                            manager.getTrains().get(i).setTrainRoute(trainRoute);
                            System.out.println("Schedule Assigned !");
                            break;
                        }
                    }
                    if (!stationAssign) {
                        System.out.println("Error Station Does not Exist !");
                    }
                }
            } else if (authentication.equals("pass")) {

                passenger.menu();
                System.out.println("Enter Choice :");
                option = input.nextInt();

                if (option == 1) {

                    System.out.println("Enter Passenger First Name:");
                    input.nextLine();
                    String firstName = input.nextLine();
                    System.out.println("Enter Passenger Last Name:");
                    String lastName = input.nextLine();
                    System.out.println("Enter CNIC Number:");
                    int cnic = input.nextInt();
                    System.out.println("Enter Age:");
                    int age = input.nextInt();

                    passengerTicket = new Ticket();

                    try {
                        passengerWriter.write("First Name :"+firstName);
                        passengerWriter.newLine();
                        passengerWriter.write("Last Name :"+lastName);
                        passengerWriter.newLine();
                        passengerWriter.write("ID :"+cnic);
                        passengerWriter.newLine();
                        passengerWriter.write("Age :"+age);
                        passengerWriter.write("Passenger Seat No. :"+passengerTicket.getPassengerSeat().getSeatNo());
                        passengerWriter.write("Passenger Carriage No. "+passengerTicket.getPassengerSeat().getCarriageNo());
                        passengerWriter.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                    System.out.println("Select Departure Location :");
                    System.out.println();
                    for (int i = 0; i < manager.getStations().size(); i++) {
                        System.out.println((i + 1) + "-  " + "Station City :" + manager.getStations().get(i).getCity());
                        System.out.println();
                    }
                    int departChoice = input.nextInt();
                    int departIndex = departChoice - 1;

                    System.out.println("Select Destination Location :");
                    System.out.println();
                    for (int i = 0; i < manager.getStations().size(); i++) {
                        System.out.println((i + 1) + "-  " + "Station City :" + manager.getStations().get(i).getCity());

                    }
                    int arrivalChoice = input.nextInt();
                    int arrivalIndex = arrivalChoice - 1;
                    String departure = manager.getStations().get(departIndex).getStationName();
                    String arrival = manager.getStations().get(arrivalIndex).getStationName();

                    for (int i = 0; i < manager.getTrains().size(); i++) {
                        if (manager.getTrains().get(i).getTrainRoute().getDepartureStation().getStationName().equals(departure) && manager.getTrains().get(i).getTrainRoute().getArrivalStation().getStationName().equals(arrival)) {
                            passengerTicket.setTicketTrain(manager.getTrains().get(i));
                        } else {
                            System.out.println("Train Not Available");
                        }
                    }

                    System.out.println("Enter Distance Between Departure And Arrival Station (IN KM) :");
                    int distance = input.nextInt();
                    Route.distanceBetweenStations = distance;

                    System.out.println("Choose Train Class Type :");

                    System.out.println(1 + " - Business Class");
                    System.out.println(2 + " - Economy Class");

                    int classType = input.nextInt();


                    if (classType == 1) {
                        passengerTicket.setBusinessClass(businessClass);
                        passengerTicket.setEconomyClass(null);

                    } else if (classType == 2) {
                        passengerTicket.setBusinessClass(null);
                        passengerTicket.setEconomyClass(economyClass);
                    }

                    manager.addPassenger(cnic, firstName, lastName, age, passengerTicket);
                    int passengerIndex = manager.getPassengerByDetails(cnic);

                    passengerTicket.generatePassengerSeat();

                    passengerTicket.setPassenger(manager.getPassengers().get(passengerIndex));

                    passengerTicket.calculateFare();

                    for (int i = 0; i < manager.getTrains().size(); i++) {
                        if (trainNumber == manager.getTrains().get(i).getTrainNUmber()) {
                            manager.getTrains().get(i).setRemainingSeats(remainingSeats - 1);
                        }
                    }


                } else if (option == 2) {
                    manager.displayPassengerDetails();
                } else if (option == 3) {
                    try {
                        passengerTicket.ProcessPayment();
                    } catch (NullPointerException e) {
                        System.out.println("Error ! Please Buy Ticket First");
                    }

                } else if (option == 4) {
                    int rate = 0;
                    input.nextLine();
                    System.out.println("Enter Name :");
                    String name = input.nextLine();
                    System.out.println("Enter Contact :");
                    int contact = input.nextInt();
                    System.out.println("Overall Experience ?");
                    System.out.println(1 + "- Good");
                    System.out.println(2 + "- Average ");
                    System.out.println(3 + "- Bad ");
                    int experience = input.nextInt();
                    if (experience == 1) {
                        rate = 1;
                    } else if (experience == 2) {
                        rate = 2;
                    } else if (experience == 3) {
                        rate = 3;
                    }
                    System.out.println();
                    System.out.println("Enter Your FeedBack :");
                    System.out.println();
                    input.nextLine();
                    String feedback = input.nextLine();

                    Feedback passengerFeedback = new Feedback(name, feedback, contact, rate);

                    System.out.println("ThankYou, Your FeedBack Has Been Added !");
                }


            }
        } while (choice != 0 || option != 0);
    }
}
