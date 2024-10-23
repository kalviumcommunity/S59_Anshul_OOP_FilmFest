package Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private List<Movie> movies;

    public MovieList() {
        this.movies = new ArrayList<>();

        // Add regular movies
        movies.add(new Movie("Inception", "Sci-Fi", 12.99));
        movies.add(new Movie("The Godfather", "Crime", 14.99));

        // Add animated movies
        movies.add(new AnimatedMovie("Toy Story", "Animation", 9.99, "Pixar"));
        movies.add(new AnimatedMovie("Finding Nemo", "Animation", 10.99, "Pixar"));

        // Add documentary movies
        movies.add(new DocumentaryMovie("Planet Earth", "Documentary", 7.99, "Nature"));
        movies.add(new DocumentaryMovie("The Last Dance", "Documentary", 8.99, "Michael Jordan"));
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovie(String title) {
        return movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }

    public Movie selectMovie(int index) {
        if (index > 0 && index <= movies.size()) {
            return movies.get(index - 1);
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
    }
}
