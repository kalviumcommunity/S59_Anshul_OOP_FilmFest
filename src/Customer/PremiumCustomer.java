package Customer;

import Movie.Movie;

public class PremiumCustomer extends Customer {
    private double discountRate;

    public PremiumCustomer(String name, double discountRate) {
        super(); // Calls the constructor of Customer
        this.setName(name);
        this.setCustomerID(generateCustomerID());
        this.discountRate = discountRate;
    }

    // runtime polymorphism demonstrated here
    @Override
    public void checkout() {
        if (getCart().isEmpty()) {
            System.out.println("Your cart is empty. Add movies to the cart before checking out.");
        } else {
            double total = 0;
            for (Movie movie : getCart()) {
                total += movie.getPrice();
            }
            double discountedTotal = total * (1 - discountRate);
            System.out.println("Total amount to pay (after discount): $" + discountedTotal);
            getCart().clear(); // Empty the cart after checkout
            System.out.println("Thank you for your purchase, Premium Customer!");
        }
    }
}
