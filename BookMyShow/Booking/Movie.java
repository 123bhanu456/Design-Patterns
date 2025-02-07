package Booking;

public class Movie {
    private int movie_id;
    private String title;
    private Genre genre;
    private int duration_in_hr;
    private double rating;

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

    public  int getDuration_in_hr(){
        return duration_in_hr;
    }

    public Genre getGenre(){
        return genre;
    }

    public double getRating(){
        return rating;
    }
}
