public class Show {
    int show_id;
    Movie movie;
    Theater theater;
    String time;
    Screen screen;
    int available_seats;

    Show(int show_id,Movie movie,Theater theater,String time){

        this.show_id=show_id;
        this.movie=movie;
        this.theater=theater;
        this.time=time;

        this.screen=theater.getMovieScreen(movie);
        this.available_seats= screen.total_seats;
    }

    public void getAvailable_seats(){
        screen.display_layout();
        System.out.println("Available seats = "+available_seats);
    }

    public void bookShow(int row,int column){
        theater.book(movie,row,column);
        available_seats=screen.total_seats;
    }
}
