package com.Spring.CarRental.exceptions;

public class UserNotRegistered extends RuntimeException {
    public UserNotRegistered(String message) {
        super(message);
    }
}
