package Booking;

import Payment.PaymentFactory;

public interface ScreenInf {
    void blockSeat(int seat_id);
    void display_layout();
    void display_layout_afterBooking();
    void setMovie(Movie movie);
    String getSeatStatus(int seat_id);
}
