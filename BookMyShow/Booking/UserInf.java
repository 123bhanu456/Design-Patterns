package Booking;

import Payment.PaymentFactory;

import java.util.List;

public interface UserInf {
    void book_show(Show show, int seat_id, PaymentFactory payment);
    void book_show(Show show, List<Integer> arr,PaymentFactory payment);


}
