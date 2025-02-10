package Booking;

public interface ScreenInf {
    boolean blockSeat(int seat_id);
    void display_layout();
    void display_layout_afterBooking();
    void setMovie(Movie movie);
    String getSeatStatus(int seat_id);
}
