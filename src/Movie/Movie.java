package Movie;

public class Movie {
    private String title;
    private String genre;
    private double price;

    public Movie(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Price: $" + price;
    }
}