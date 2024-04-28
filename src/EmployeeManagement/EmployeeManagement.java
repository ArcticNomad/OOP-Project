package EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;
import StationManagement.StationManagement;
import Employee.Employee;
public class EmployeeManagement extends StationManagement
{
    ArrayList<Employee> employees=new ArrayList<>();
    private String employeeName;
    private int employeeID;
    private String employeeRole;

    public void addEmployee()
    {
            Scanner input=new Scanner(System.in);
            System.out.println("Enter Employee ID :");
            int ID=input.nextInt();
            System.out.println("Enter Employee Name :");
            input.nextLine();
            String name=input.nextLine();
            System.out.println("Enter Employee Role :");
            String role=input.nextLine();

            employees.add(new Employee(ID,name,role));

    }

    public void displayEmployees()
    {
        for (Employee e: employees)
        {
            System.out.println("Employee Name :"+e.getEmployeeName());
            System.out.println("Employee ID :"+e.getEmployeeID());
            System.out.println("Employee Role :"+e.getEmployeeRole());
        }
    }
    public void removeEmployee(int employeeID)
    {
        for (int i=0;i<employees.size();i++)
        {
            if(employees.get(i).getEmployeeID()==employeeID)
            {
                employees.remove(i);
            }
        }
    }
    public void updateRoles(String role, int employeeID)
    {
        for (int i=0;i<employees.size();i++)
        {
            if(employees.get(i).getEmployeeID()==employeeID)
            {
                employees.get(i).updateRole(role);
            }
        }
    }
    public void EmployeeSchedule()
    {}


}
