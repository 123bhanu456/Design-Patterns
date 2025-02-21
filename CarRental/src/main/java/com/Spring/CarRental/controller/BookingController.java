package com.Spring.CarRental.controller;

import com.Spring.CarRental.Entity.Booking;
import com.Spring.CarRental.Entity.Car;
import com.Spring.CarRental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @GetMapping("/ShowBookings")
    public List<Booking>showBookings(){
        return bookingService.showBookings();
    }

    @GetMapping("/ShowCar")
    public List<Car> showCars(){
        return bookingService.showCars();
    }

    @PostMapping("/Book")
    public Car BookCar(@RequestBody Booking booking){
        return bookingService.bookCar(booking);
    }








}
