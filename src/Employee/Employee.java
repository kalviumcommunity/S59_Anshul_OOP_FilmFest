package Employee;

import Movie.Movie;
import java.util.ArrayList;
import java.util.List;


public class Employee {
    //Abstraction Concept Utilized
    private String employeeID;
    private String name;
    public static final String HELP_MESSAGE = "For assistance, please contact our Support Team:\n" +
            "Phone: 1-800-987-6543\n" +
            "Email: support@movieportal.com";

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
    public static void displayHelp() {
        System.out.println(HELP_MESSAGE);
    }
}
