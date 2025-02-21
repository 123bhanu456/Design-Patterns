package com.Spring.CarRental.Repo;

import com.Spring.CarRental.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo  extends MongoRepository<Booking,String> {

}
