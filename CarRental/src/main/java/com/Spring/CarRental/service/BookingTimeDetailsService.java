package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.BookingTimeDetails;
import com.Spring.CarRental.Repo.BookingTimeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingTimeDetailsService implements BookingTimeDetailsServiceInf{

    BookingTimeDetailsRepo bookingTimeDetailsRepo;

    @Autowired
    public BookingTimeDetailsService(BookingTimeDetailsRepo bookingTimeDetailsRepo){
        this.bookingTimeDetailsRepo=bookingTimeDetailsRepo;
    }


    @Override
    public BookingTimeDetails add(BookingTimeDetails bookingTimeDetails) {
        return bookingTimeDetailsRepo.insert(bookingTimeDetails);
    }

    @Override
    public BookingTimeDetails getBookingDetailsById(String bookingId) {
        return bookingTimeDetailsRepo.findByBookingId(bookingId);
    }

    @Override
    public BookingTimeDetails update(BookingTimeDetails bookingTimeDetails) {
        return bookingTimeDetailsRepo.save(bookingTimeDetails);
    }

    @Override
    public BookingTimeDetails remove(String BookingID) {
        return bookingTimeDetailsRepo.deleteByBookingId(BookingID);
    }


}
