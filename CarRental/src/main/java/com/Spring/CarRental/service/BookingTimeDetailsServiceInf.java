package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.Booking;
import com.Spring.CarRental.Entity.BookingTimeDetails;

public interface BookingTimeDetailsServiceInf {
         BookingTimeDetails add(BookingTimeDetails bookingTimeDetails);
         BookingTimeDetails getBookingDetailsById(String bookingId);
         BookingTimeDetails update(BookingTimeDetails bookingTimeDetails);
         BookingTimeDetails remove(String BookingID);
}
