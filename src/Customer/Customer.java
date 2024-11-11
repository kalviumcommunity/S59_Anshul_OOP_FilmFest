package Customer;

import Abstract.User;
import Movie.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// SOLID PRINCIPLE LSP USED
public class Customer extends User {
    private List<Movie> cart;
    public static String HELP_MESSAGE = "For assistance, please contact our Customer Care:\n" +
            "Phone: 1-800-123-4567\n" +
            "Email: support@movieportal.com";

    public Customer() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + userID);
        System.out.println("Name: " + name);
    }

    // Getter for cart
    public List<Movie> getCart() {
        return cart;
    }

    public static String generateCustomerID() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999
        return String.valueOf(id);
    }

    public void register(String name) {
        this.userID = generateCustomerID();
        this.name = name;
        System.out.println("Registration successful. Your Customer ID is: " + userID);
    }

    public boolean isRegistered() {
        return !userID.isEmpty();
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
