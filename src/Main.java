import EmployeeManagement.EmployeeManagement;
import StationManagement.StationManagement;
import Station.Station;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        StationManagement manager=new StationManagement();
        EmployeeManagement employeeManager=new EmployeeManagement();
        int choice=0;



        do
        {
            manager.menu();
            choice = input.nextInt();
            if (choice == 1)
            {
                manager.addStation();
            } else if (choice==2)
            {
                System.out.println("Enter Name of Station to Be Removed :");
                input.nextLine();
                String station= input.nextLine();
                manager.removeStation(station);
            } else if (choice==3)
            {
                manager.displayStations();
            } else if (choice==4)
            {
                manager.displayFacilities();
            } else if (choice==5)
            {
                employeeManager.addEmployee();
            } else if (choice==6)
            {
                employeeManager.displayEmployees();
            } else if (choice==7)
            {
                System.out.println("Enter Employee ID :");
                int id=input.nextInt();
                employeeManager.removeEmployee(id);
            } else if (choice==8)
            {
                System.out.println("Enter Role :");
                input.nextLine();
                String role=input.nextLine();
                System.out.println("Enter ID :");
                int id=input.nextInt();

                employeeManager.updateRoles(role,id);

            } else if (choice==9)
            {
                System.out.println("Enter Train Number :");
                int trainNum=input.nextInt();
                System.out.println("Enter Train Speed (KM/H) :");
                int speed=input.nextInt();
                System.out.println("Enter Train Capacity :");
                int capacity=input.nextInt();

                // IT WOULD BE BETTER TO DISPLAY ALL THE STATIONS AND LET THE USER SELECT,
                // RATHER THAN GETTING THE STATION NAME

                System.out.println("Enter Station Where You Would Like To Add the Train :");
                String stationName=input.nextLine();
                for (Station currentStation: manager.stations)
                {
                    if(currentStation.getStationName().equals(stationName))
                    {
                        manager.addTrain(trainNum,speed,capacity,currentStation);
                    }
                    else
                    {
                        System.out.println("Incorrect Station Entered ");
                    }
                }

            } else if (choice==10)
            {

            }

        }while (choice!=0);

    }

}