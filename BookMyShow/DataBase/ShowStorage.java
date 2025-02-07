package DataBase;

import Booking.Movie;
import Booking.Screen;
import Booking.Show;

import java.util.ArrayList;
import java.util.List;

public class ShowStorage {
    private List<Show> shows = new ArrayList<>();
    private static ShowStorage showStorageVar;

        private ShowStorage(){

        }

        public static ShowStorage getInstance(){
            if(showStorageVar==null){
                showStorageVar=new ShowStorage();
            }
            return showStorageVar;
        }


        public void addShow(Show show) {
            shows.add(show);
        }

        public List<Show> searchShowsByMovie(Movie movie){
            List<Show>result=new ArrayList<>();

            for(Show show:shows){
               Screen s=show.getTheater().getScreenForMovie(movie);
               if(s!=null&&show.getMovie()==movie)result.add(show);
            }


            return result;
        }


    }

