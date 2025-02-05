import java.util.ArrayList;
import java.util.List;

public class Theater {

    int Theater_id;
    String name;
    String location;
    List<Screen> screens;
    int max_total_Screens;
    List<Movie> current_movies;

    Theater(int max_total_Screens, String name, String location, int Theater_id) {
        this.name = name;
        this.location = location;
        this.Theater_id = Theater_id;
        this.max_total_Screens = max_total_Screens;
        screens = new ArrayList<Screen>(max_total_Screens);
        int id=0;
        for(int i=0;i<max_total_Screens;i++){
            Screen s=new Screen(id,5,5);
            screens.add(s);
            id++;
        }
        current_movies = new ArrayList<Movie>(max_total_Screens);
    }

    List<Movie> getCurrent_movies() {
        return current_movies;
    }

    public void setCurrent_movies(Movie movie) {
        if (current_movies.size() == max_total_Screens) {
            System.out.println("Can not set movie as Screens are Full");
            return;
        }
        screens.get(current_movies.size()).setMovie(movie);
        current_movies.add(movie);

    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void book(Movie movie,int row,int column){
        Screen s=getMovieScreen(movie);
        if(s==null) {
            System.out.println("No movie in this theater");
            return;
        }
        if(s.total_seats==0){
            System.out.println("theater is full");
        }
        s.blockSeat(row,column);
        s.pay();
        s.display_layout_afterBooking();
    }


    public Screen getMovieScreen(Movie movie) {
        Screen x=null;
        for (int i = 0; i < current_movies.size(); i++) {
            if (current_movies.get(i) == movie) {
                x = screens.get(i);
            }
        }
        return x;

    }
}

























