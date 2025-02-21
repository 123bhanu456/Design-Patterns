package com.Spring.CarRental.Repo;

import com.Spring.CarRental.Entity.BookingTimeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingTimeDetailsRepo extends MongoRepository<BookingTimeDetails,String> {
    BookingTimeDetails findByBookingId(String bookingId);
    BookingTimeDetails deleteByBookingId(String bookingId);
}
