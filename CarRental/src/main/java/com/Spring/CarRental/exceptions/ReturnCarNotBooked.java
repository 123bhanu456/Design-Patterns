package com.Spring.CarRental.exceptions;

public class ReturnCarNotBooked extends RuntimeException {
    public ReturnCarNotBooked(String message) {
        super(message);
    }
}
