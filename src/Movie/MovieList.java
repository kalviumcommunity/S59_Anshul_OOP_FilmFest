package Movie;

import Movie.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private List<Movie> movies;

    public MovieList() {
        this.movies = new ArrayList<>();

        movies.add(new Movie("Inception", "Sci-Fi", 12.99));
        movies.add(new Movie("The Godfather", "Crime", 14.99));
        movies.add(new Movie("The Shawshank Redemption", "Drama", 11.99));
        movies.add(new Movie("The Dark Knight", "Action", 13.99));
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovie(String title) {
//        Delete Operation Used Here
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

