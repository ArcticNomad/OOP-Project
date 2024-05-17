package com.example.trainmanagementproject.backendClasses.EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;
import com.example.trainmanagementproject.backendClasses.StationManagement.StationManagement;
import com.example.trainmanagementproject.backendClasses.Employee.Employee;
public class EmployeeManagement extends StationManagement
{
    ArrayList<Employee> employees=new ArrayList<>();
    private String employeeName;
    private int employeeID;
    private String employeeRole;

    public void addEmployee(int ID, String name, String role)
    {
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
        if(employees.isEmpty())
        {
            System.out.println("No Employees to Remove !");
        }
        for (int i=0;i<employees.size();i++)
        {
            if(employees.get(i).getEmployeeID()==employeeID)
            {
                employees.remove(i);
                System.out.println("Employee Removed");
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
