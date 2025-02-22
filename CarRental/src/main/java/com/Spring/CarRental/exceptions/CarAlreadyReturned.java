package com.Spring.CarRental.exceptions;

public class CarAlreadyReturned extends RuntimeException {
    public CarAlreadyReturned(String message) {
        super(message);
    }
}
