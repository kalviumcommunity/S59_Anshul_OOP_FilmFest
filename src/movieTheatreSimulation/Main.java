package movieTheatreSimulation;

import java.util.Scanner;
import Customer.Customer;
import Customer.PremiumCustomer;
import Employee.Employee;
import Movie.Movie;
import Movie.MovieList;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList movieList = new MovieList();

        System.out.println("Welcome to the Movie Theatre Simulation!");
        System.out.println("Are you a Customer or an Employee?");
        System.out.println("1. Customer");
        System.out.println("2. Employee");
        System.out.print("Please enter your choice (1 or 2): ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: // Customer
                System.out.println("Welcome Customer");
                System.out.println("Are you a regular or premium customer?");
                System.out.println("1. Register as Regular Customer");
                System.out.println("2. Register as Premium Customer");
                System.out.println("3. Enter CustomerID");
                System.out.println("4. Exit");
                System.out.print("Please enter your choice (1, 2, 3, or 4): ");

                int customerChoice = sc.nextInt();
                sc.nextLine();

                Customer customer = null;

                switch (customerChoice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        customer = new Customer();
                        customer.register(name);
                        break;
                    case 2:
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter Discount Rate (e.g., 0.1 for 10%): ");
                        double discountRate = sc.nextDouble();
                        sc.nextLine();
                        customer = new PremiumCustomer(name, discountRate);
                        System.out.println("Registration successful. You are now a Premium Customer.");
                        break;
                    case 3:
                        System.out.print("Enter CustomerID: ");
                        String enteredID = sc.nextLine();
                        customer = new Customer();
                        customer.setCustomerID(enteredID);
                        customer.setName("Placeholder Name");
                        customer.displayCustomerInfo();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                if (customerChoice == 1 || customerChoice == 2 || customerChoice == 3) {
                    boolean continueShopping = true;
                    while (continueShopping) {
                        System.out.println("1. View Movies");
                        System.out.println("2. Add Movie to Cart");
                        System.out.println("3. View Cart");
                        System.out.println("4. Checkout");
                        System.out.println("5. Help");
                        System.out.println("6. Exit");
                        System.out.print("Please enter your choice (1-6): ");

                        int actionChoice = sc.nextInt();
                        sc.nextLine();

                        switch (actionChoice) {
                            case 1:
                                movieList.displayMovies();
                                break;
                            case 2:
                                System.out.print("Select a movie by number: ");
                                int movieChoice = sc.nextInt();
                                sc.nextLine();

                                Movie selectedMovie = movieList.selectMovie(movieChoice);
                                if (selectedMovie != null) {
                                    customer.addToCart(selectedMovie);
                                }
                                break;
                            case 3:
                                customer.viewCart();
                                break;
                            case 4:
                                customer.checkout();
                                break;
                            case 5:
                                Customer.displayHelp();
                                break;
                            case 6:
                                System.out.println("Exiting...");
                                continueShopping = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                }
                customer = null;
                break;

            case 2: // Employee
                System.out.println("Welcome to FilmFest Employee Portal");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Please enter your choice (1, 2, or 3): ");

                int employeeChoice = sc.nextInt();
                sc.nextLine();

                Employee employee = new Employee();

                switch (employeeChoice) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        String empID = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String empName = sc.nextLine();
                        employee.register(empID, empName);
                        break;
                    case 2:
                        System.out.print("Enter Employee ID: ");
                        String loginID = sc.nextLine();
                        if (employee.login(loginID)) {
                            System.out.println("Login successful.");
                            employee.displayEmployeeInfo();

                            boolean continueManaging = true;
                            while (continueManaging) {
                                System.out.println("1. Add Movie");
                                System.out.println("2. Delete Movie");
                                System.out.println("3. View Movies");
                                System.out.println("4. Help");
                                System.out.println("5. Exit");
                                System.out.print("Please enter your choice (1-5): ");

                                int manageChoice = sc.nextInt();
                                sc.nextLine();

                                switch (manageChoice) {
                                    case 1:
                                        System.out.print("Enter Movie Title: ");
                                        String title = sc.nextLine();
                                        System.out.print("Enter Movie Genre: ");
                                        String genre = sc.nextLine();
                                        System.out.print("Enter Movie Rating: ");
                                        double price = sc.nextFloat();
                                        Movie newMovie = new Movie(title, genre, price);
                                        movieList.addMovie(newMovie);
                                        System.out.println("Movie added successfully.");
                                        break;
                                    case 2:
                                        System.out.print("Enter Movie Title to delete: ");
                                        String movieTitleToDelete = sc.nextLine();
                                        if (movieList.removeMovie(movieTitleToDelete)) {
                                            System.out.println("Movie removed successfully.");
                                        } else {
                                            System.out.println("Movie not found.");
                                        }
                                        break;
                                    case 3:
                                        movieList.displayMovies();
                                        break;
                                    case 4:
                                        Employee.displayHelp();
                                        break;
                                    case 5:
                                        System.out.println("Exiting...");
                                        continueManaging = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Invalid Employee ID.");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                employee = null;
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
        sc.close();
    }
}
