package Employee;

import Movie.Movie;
import java.util.ArrayList;
import java.util.List;


public class Employee {
    private String employeeID;
    private String name;

    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }

    public Employee() {
        this.employeeID = "12345";
        this.name = "";
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
    }

    public boolean login(String enteredID) {
        return this.employeeID.equals(enteredID);
    }

    public void register(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
        System.out.println("Registration successful. Your Employee ID is: " + employeeID);
    }
}
