package Customer;

import java.util.Random;

import Movie.Movie;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    //Abstraction Concept Utilized
    private String customerID;
    private String name;
    private List<Movie> cart;
    public static String HELP_MESSAGE = "For assistance, please contact our Customer Care:\n" + "Phone: 1-800-123-4567\n" + "Email: support@movieportal.com";

    public Customer() {
        // Add (NEW Operation)
        this.cart = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + name);
    }

    public static String generateCustomerID() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999
        return String.valueOf(id);
    }

    public void register(String name) {
        this.customerID = generateCustomerID();
        this.name = name;
        System.out.println("Registration successful. Your Customer ID is: " + customerID);
    }

    public boolean isRegistered() {
        return !customerID.isEmpty();
    }


    public void addToCart(Movie movie) {
        cart.add(movie);
        System.out.println(movie.getTitle() + " has been added to your cart.");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Movies in your cart:");
            for (Movie movie : cart) {
                System.out.println(movie);
            }
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add movies to the cart before checking out.");
        } else {
            double total = 0;
            for (Movie movie : cart) {
                total += movie.getPrice();
            }
            System.out.println("Total amount to pay: $" + total);
            cart.clear(); // Empty the cart after checkout
            System.out.println("Thank you for your purchase!");
        }
    }
    public static void displayHelp() {
        System.out.println(HELP_MESSAGE);
    }
}