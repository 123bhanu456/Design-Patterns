package Booking;

import Payment.PaymentFactory;

public class Show implements ShowInf{
    int show_id;
    Movie movie;
    public Theater theater;
    String time;
    Screen screen;
    int available_seats;
    int price;
    public Show(int show_id, Movie movie, Theater theater, String time){

        this.show_id=show_id;
        this.movie=movie;
        this.theater=theater;
        this.time=time;

        this.screen=theater.getMovieScreen(movie);
        if(screen!=null) {
            this.available_seats = screen.total_seats;
            this.price=screen.price;
        }
    }

    public void displayShowDetails(){
        System.out.println(" Movie-"+movie.title+" , Theater-"+theater.name+" , ScreenType-"+screen.getType()+" , time-"+time);
    }

    @Override
    public void showAvailable_seats(){

        System.out.println(movie.title+" is Present in Screen "+screen.screen_id);
        screen.display_layout();
        System.out.println("Available seats = "+available_seats);
    }

    @Override
    public void bookShow(int seat_id){
        theater.book(movie,seat_id);
        available_seats=screen.total_seats;
    }

    @Override
    public void display_seat_after_booking() {
        screen.display_layout_afterBooking();
    }

    public Movie getMovie() {
        return movie;
    }

}
