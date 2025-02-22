package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.BookingTimeDetails;
import com.Spring.CarRental.Entity.Car;
import com.Spring.CarRental.Entity.CarState;
import com.Spring.CarRental.exceptions.CarAlreadyReturned;
import com.Spring.CarRental.exceptions.ReturnCarNotBooked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ReturnService implements ReturnServiceInf {
    private BookingTimeDetailsService bookingTimeDetailsService;
    private CarService carService;
    private BookingService bookingService;
    private static final double HOURLY_RATE = 10.0;


    @Autowired
    public ReturnService(BookingTimeDetailsService bookingTimeDetailsService,CarService carService,BookingService bookingService){
        this.bookingTimeDetailsService=bookingTimeDetailsService;
        this.carService=carService;
        this.bookingService=bookingService;
    }


    @Override
    public double returnCar(String bookingId) {
        BookingTimeDetails bookingTimeDetails=bookingTimeDetailsService.getBookingDetailsById(bookingId);

        if (bookingTimeDetails == null) {
            throw new ReturnCarNotBooked("No booking details found for booking ID: " + bookingId+" Did u Steal it??");
        }

        String carId=bookingService.getBookingById(bookingId).getCarId();
        Car car=carService.getCarById(carId);

        if(car.getCarState()==CarState.AVAILABLE){
            throw new CarAlreadyReturned("Car With id -"+carId+" is already returned , wait How do u have it? Did u steal it or what? ");
        }



        LocalDateTime startTime = bookingTimeDetails.getStartTime();
        LocalDateTime endTime = LocalDateTime.now();

        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        double amount = hours * HOURLY_RATE;
        if (minutes > 0) {
            amount += HOURLY_RATE * (minutes / 60.0);
        }

        bookingTimeDetails.setAmount(amount);
        bookingTimeDetails.setEndTime(endTime);

        car.setCarState(CarState.AVAILABLE);


        bookingTimeDetailsService.remove(bookingTimeDetails.getBookingId());
        bookingTimeDetailsService.update(bookingTimeDetails);
        carService.updateCar(car);


        return amount;
    }
}
