package com.Spring.CarRental.exceptions;

public class CarAlreadyBooked extends RuntimeException {
    public CarAlreadyBooked(String message) {
        super(message);
    }
}
