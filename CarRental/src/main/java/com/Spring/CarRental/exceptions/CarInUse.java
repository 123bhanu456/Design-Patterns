package com.Spring.CarRental.exceptions;

public class CarInUse extends RuntimeException {
    public CarInUse(String message) {
        super(message);
    }
}
