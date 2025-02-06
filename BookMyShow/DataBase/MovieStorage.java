package DataBase;

import Booking.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieStorage {
    private Map<String, Movie> movieMap;

    public MovieStorage() {
        this.movieMap = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName().toLowerCase(), movie);
    }


    public Movie getMovie(String name) {
        return movieMap.get(name.toLowerCase());
    }

    public boolean containsMovie(String name) {
        return movieMap.containsKey(name.toLowerCase());
    }
}

