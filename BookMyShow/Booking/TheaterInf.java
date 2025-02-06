package Booking;

import Payment.PaymentFactory;

public interface TheaterInf {
    void setCurrent_movies(Movie movie);
    void showMovies();
    void initMovieScreen(int id,int row,int column,ScreenType screenType);

}
