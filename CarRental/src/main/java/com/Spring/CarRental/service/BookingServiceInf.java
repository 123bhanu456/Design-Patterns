package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.Booking;
import com.Spring.CarRental.Entity.Car;

import java.util.List;
import java.util.Optional;

public interface BookingServiceInf {

    List<Car> showCars();
    Car bookCar(Booking booking);

    List<Booking>showBookings();
    Booking getBookingById(String bookingId);
}
