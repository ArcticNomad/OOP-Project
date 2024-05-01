import EmployeeManagement.EmployeeManagement;
import Passenger.Passenger;
import Route.Route;
import StationManagement.StationManagement;
import Station.Station;
import Route.Route;
import Ticket.Ticket;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);

        StationManagement manager=new StationManagement();
        EmployeeManagement employeeManager=new EmployeeManagement();
        Passenger passenger=new Passenger();
        Ticket passengerTicket=new Ticket();


        int choice=0;
        int option=0;






                do
                {
                    System.out.println("Enter Authentication :");
                    String authentication=input.nextLine();
                    if (authentication.equals("admin")) {

                        manager.menu();
                        choice = input.nextInt();
                        if (choice == 1) {
                            manager.addStation();
                        } else if (choice == 2) {
                            System.out.println("Enter Name of Station to Be Removed :");
                            input.nextLine();
                            String station = input.nextLine();
                            manager.removeStation(station);
                        } else if (choice == 3) {
                            manager.displayStations();
                        } else if (choice == 4) {
                            manager.displayFacilities();
                        } else if (choice == 5) {
                            employeeManager.addEmployee();
                        } else if (choice == 6) {
                            employeeManager.displayEmployees();
                        } else if (choice == 7) {
                            System.out.println("Enter Employee ID :");
                            int id = input.nextInt();
                            employeeManager.removeEmployee(id);
                        } else if (choice == 8) {
                            System.out.println("Enter Role :");
                            input.nextLine();
                            String role = input.nextLine();
                            System.out.println("Enter ID :");
                            int id = input.nextInt();

                            employeeManager.updateRoles(role, id);

                        } else if (choice == 9) {
                            System.out.println("Enter Train Number :");
                            int trainNum = input.nextInt();
                            System.out.println("Enter Train Speed (KM/H) :");
                            int speed = input.nextInt();
                            System.out.println("Enter Train Capacity :");
                            int capacity = input.nextInt();
                            input.nextLine();
                            System.out.println("Enter Facility of Train");
                            String facility = input.nextLine();
                            System.out.println("Enter Departure Time of Train :");
                            int departTime=input.nextInt();
                            System.out.println("Enter Arrival Time gf Train ");
                            int arrivalTime=input.nextInt();

                            // IT WOULD BE BETTER TO DISPLAY ALL THE STATIONS AND LET THE USER SELECT,
                            // RATHER THAN GETTING THE STATION NAME

                            input.nextLine();
                            System.out.println("Enter Station Where You Would Like To Add the Train :");
                            String stationName = input.nextLine();
                            for (int i = 0; i < StationManagement.stations.size(); i++) {
                                if (StationManagement.stations.get(i).getStationName().equals(stationName)) {
                                    manager.addTrain(trainNum, speed, capacity, StationManagement.stations.get(i), facility, arrivalTime, departTime);
                                    System.out.println("Train added Successfully");

                                } else
                                    System.out.println("Incorrect Station Entered ");
                            }


                        } else if (choice == 10)
                        {
                        }
                    }
                        else if (authentication.equals("pass"))
                        {
                            passenger.addPassenger(passengerTicket);
                            System.out.println();
                            passenger.menu();
                            System.out.println("Enter Choice :");
                            option=input.nextInt();

                            if(option==1) {

                                System.out.println("Select Departure Location :");
                                System.out.println();
                                for (int i = 0; i < StationManagement.stations.size(); i++) {
                                    System.out.println((i + 1) + "-  " + "Station Location :" + StationManagement.stations.get(i).getLocation());
                                    System.out.println();
                                }
                                int departChoice = input.nextInt();
                                int departIndex = departChoice - 1;

                                StationManagement.stations.get(departIndex).buyTicket(departIndex);

                                System.out.println("Enter Distance Between Departure And Arrival Station :");
                                int distance = input.nextInt();
                                Route.distanceBetweenStations = distance;

                                passengerTicket.calculateFare();
                                passengerTicket.ProcessPayment();

                            }
                            else if (option==2)
                            {
                                passenger.displayPassengerDetails();
                            }


                        }


                } while (choice != 0||option!=0);


    }

}