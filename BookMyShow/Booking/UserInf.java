package Booking;

import Payment.Payment;

import java.util.List;

public interface UserInf {
    void book_show(Show show, int seat_id, Payment payment);
    void book_show(Show show, List<Integer> arr,Payment payment);


}
