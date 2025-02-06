package Booking;

public class Movie {
    int movie_id;
    String title;
    Genre genre;
    int duration_in_hr;
    double rating;

    public Movie(int movie_id, String title, Genre genre, int duration, double rating){
        this.duration_in_hr=duration;
        this.movie_id=movie_id;
        this.genre=genre;
        this.title=title;
        this.rating=rating;
    }


    public String getName() {
        return title;
    }
}
