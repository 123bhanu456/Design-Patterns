package com.Spring.CarRental.exceptions;

public class AlreadyDeleted_NotExistException extends RuntimeException {
    public AlreadyDeleted_NotExistException(String message) {
        super(message);
    }
}
