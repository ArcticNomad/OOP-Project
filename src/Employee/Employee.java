package Employee;

public class Employee
{
    private int employeeID;
    private String employeeName;
    private String employeeRole;

    public void displayEmployeeDetails()
    {}

    public Employee(int employeeID, String employeeName,String employeeRole)
    {
        setEmployeeID(employeeID);
        setEmployeeRole(employeeRole);
        setEmployeeName(employeeName);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }
    public void updateRole(String employeeRole)
    {
        this.employeeRole=employeeRole;
    }
}
