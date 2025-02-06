package Booking;

import Payment.PaymentFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theater implements TheaterInf{

    int Theater_id;
    String name;
    String location;
    List<Screen> screens;
    int max_total_Screens;
    List<Movie> current_movies;
    Map<Movie,Screen> m;


    public Theater(int Theater_id, int max_total_Screens, String name, String location) {
        this.name = name;
        this.location = location;
        this.Theater_id = Theater_id;
        this.max_total_Screens = max_total_Screens;
        screens = new ArrayList<Screen>(max_total_Screens);
        current_movies = new ArrayList<Movie>(max_total_Screens);
        m= new HashMap<>();
    }

    @Override
    public void initMovieScreen(int id,int row,int column,ScreenType screenType){
        screens.add(new Screen(id,row,column,screenType));

    }

    @Override
    public void setCurrent_movies(Movie movie) {
        if (current_movies.size() == max_total_Screens) {
            System.out.println("Can not set movie as Screens are Full");
            return;
        }
        if(current_movies.contains(movie)){
            System.out.println("Booking.Movie already exist in this theater");
            return;
        }
        m.put(movie,screens.getFirst());
        current_movies.add(movie);

    }


    public void book(Movie movie, int sead_id){
        Screen s=getMovieScreen(movie);
        if(s.total_seats==0){
            System.out.println("theater is full");
        }
        s.blockSeat(sead_id);
        s.pay();
    }


    public Screen getMovieScreen(Movie movie) {
        return m.get(movie);

    }

    @Override
    public void showMovies(){
        for (int i = 0; i < current_movies.size(); i++) {
            System.out.println("Screen -"+screens.get(i).screen_id+" "+current_movies.get(i).title);
        }
    }



    


}

























