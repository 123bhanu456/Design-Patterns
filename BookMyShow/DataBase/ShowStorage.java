package DataBase;

import Booking.Movie;
import Booking.Screen;
import Booking.Show;

import java.util.ArrayList;
import java.util.List;

public class ShowStorage {


        private List<Show> shows = new ArrayList<>();

        public void addShow(Show show) {
            shows.add(show);
        }

        public List<Show> searchShowsByMovie(Movie movie){
            List<Show>result=new ArrayList<>();

            for(Show show:shows){
               Screen s=show.theater.getMovieScreen(movie);
               if(s!=null&&show.getMovie()==movie)result.add(show);
            }


            return result;
        }


    }

