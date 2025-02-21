package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.*;
import com.Spring.CarRental.Entity.state.State;
import com.Spring.CarRental.Repo.BookingRepo;
import com.Spring.CarRental.exceptions.CarAlreadyBooked;
import com.Spring.CarRental.exceptions.CarDoesnotExist;
import com.Spring.CarRental.exceptions.CarInUse;
import com.Spring.CarRental.exceptions.UserNotRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService implements BookingServiceInf {
    BookingRepo bookingRepo;
    CarService carService;
    UserService userService;
    BookingTimeDetailsService bookingTimeDetailsService;

    State booked;
    @Autowired
    public BookingService(BookingRepo bookingRepo,UserService userService,CarService carService,@Qualifier("booked")State booked,BookingTimeDetailsService bookingTimeDetailsService){
        this.bookingRepo=bookingRepo;
        this.carService=carService;
        this.userService=userService;
        this.booked=booked;
        this.bookingTimeDetailsService=bookingTimeDetailsService;
    }

    public List<Car> showCars(){
        return carService.getAllCar();
    }

    @Override
    public Car bookCar(Booking booking) {
        String carId=booking.getCarId();
        String userId=booking.getUserId();
       Car car=carService.getCarById(carId);
       User user=userService.getUserById(userId);

       if(car==null){
           throw new CarDoesnotExist("Car with id "+carId+" does not Exist");
       }
       else if(user==null){
           throw new UserNotRegistered("User with id "+userId+" should register");
       }


       CarState carState=car.getCarState();

       if(carState==CarState.BOOKED){
           throw new CarAlreadyBooked("Car with id "+carId+" is already booked");
       }
       else if(carState==CarState.IN_USE){
           throw new CarInUse("Car with id "+carId+" is already in use by someone else");
       }

       car.setCarState(CarState.BOOKED);
       car.setState(booked);

       carService.updateCar(car);

       bookingRepo.insert(booking);


        System.out.println(booking.getBookingId());

        BookingTimeDetails bookingTimeDetails= new BookingTimeDetails(booking.getBookingId(), LocalDateTime.now());
        bookingTimeDetailsService.add(bookingTimeDetails);



       return car;


    }

    @Override
    public List<Booking> showBookings() {
        return bookingRepo.findAll();
    }


}
