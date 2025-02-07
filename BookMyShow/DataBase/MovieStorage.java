package DataBase;

import Booking.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieStorage {
    private Map<String, Movie> movieMap=new HashMap<>();
    private static MovieStorage movieStorageVar;
   private MovieStorage() {
    }


    public static MovieStorage getInstance(){
       if(movieStorageVar==null) {
           movieStorageVar=new MovieStorage();
       }

       return movieStorageVar;
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

