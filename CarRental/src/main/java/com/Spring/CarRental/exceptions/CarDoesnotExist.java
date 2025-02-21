package com.Spring.CarRental.exceptions;

public class CarDoesnotExist extends RuntimeException {
    public CarDoesnotExist(String message) {
        super(message);
    }
}
