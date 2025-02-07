package Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theater implements TheaterInf{

    private int Theater_id;
    private String name;
    private String location;
    private List<Screen> screens;
    private int max_total_Screens;
    private List<Movie> movies;
    private Map<Movie,Screen> map_MovieToScreen;


    public Theater(int Theater_id, int max_total_Screens, String name, String location) {
        this.name = name;
        this.location = location;
        this.Theater_id = Theater_id;
        this.max_total_Screens = max_total_Screens;
        screens = new ArrayList<Screen>(max_total_Screens);
        movies = new ArrayList<Movie>(max_total_Screens);
        map_MovieToScreen = new HashMap<>();
    }

    @Override
    public void initializeScreen(int id, int row, int column, ScreenType screenType){
        screens.add(new Screen(id,row,column,screenType));
    }

    @Override
    public void addMovie(Movie movie) {
        if (movies.size() == max_total_Screens) {
            System.out.println("Can not set movie as Screens are Full");
            return;
        }
        if(movies.contains(movie)){
            System.out.println("Booking.Movie already exist in this theater");
            return;
        }

        for(Screen screen:screens){
            if(screen.getMovie()==null){
                map_MovieToScreen.put(movie,screen);
                screen.setMovie(movie);
                break;
            }
        }
        movies.add(movie);

    }


    public void book(Movie movie, int sead_id){
        if(!movies.contains(movie)){
            System.out.println(movie.getName()+" is not present in this theater");
            return;
        }
        Screen s= getScreenForMovie(movie);
        if(s.getTotal_seats()==0){
            System.out.println("theater is full");
            return;
        }
        s.blockSeat(sead_id);
        s.pay();
    }


    public Screen getScreenForMovie(Movie movie) {
        return map_MovieToScreen.get(movie);

    }

    @Override
    public void showMovies(){
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("Screen -"+screens.get(i).getScreen_id()+" "+screens.get(i).getMovie());
        }
    }

    public int getTheater_id() {
        return Theater_id;
    }

    public int getMax_total_Screens() {
        return max_total_Screens;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }


}

























