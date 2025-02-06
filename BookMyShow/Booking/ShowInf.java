package Booking;

import Payment.PaymentFactory;

public interface ShowInf {
    void showAvailable_seats();
    void bookShow(int seat_id);
    void display_seat_after_booking();
}
