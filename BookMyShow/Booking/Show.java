package Booking;

public class Show implements ShowInf{
    private int show_id;
    private Movie movie;
    private Theater theater;
    private String time;
    private Screen screen;
    private int available_seats;
    private int price;
    public Show(int show_id, Movie movie, Theater theater, String time){

        this.show_id=show_id;
        this.movie=movie;
        this.theater=theater;
        this.time=time;

        this.screen=theater.getScreenForMovie(movie);
        if(screen!=null) {
            this.available_seats = screen.getTotal_seats();
            this.price=screen.getPrice();
        }
    }

    public void displayShowDetails(){
        System.out.println(" Movie-"+movie.getName()+" , Theater-"+theater.getName()+" , ScreenType-"+screen.getSeatType()+" , time-"+time+" , Price-"+price+" , Available Seats-"+available_seats);
    }

    @Override
    public void showAvailable_seats(){

        System.out.println(movie.getName()+" is Present in Screen "+screen.getScreen_id());
        screen.display_layout();
        System.out.println("Available seats = "+available_seats);
    }

    @Override
    public void bookShow(int seat_id){
        theater.book(movie,seat_id);
        available_seats=screen.getTotal_seats();
    }

    @Override
    public void display_seat_after_booking() {
        screen.display_layout_afterBooking();
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public int getPrice() {
        return price;
    }

    public Screen getScreen() {
        return screen;
    }

    public String getTime() {
        return time;
    }

    public int getAvailable_seats() {
        return available_seats;
    }


}
