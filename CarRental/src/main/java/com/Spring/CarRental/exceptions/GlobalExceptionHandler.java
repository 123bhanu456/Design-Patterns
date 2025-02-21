package com.Spring.CarRental.exceptions;

import com.Spring.CarRental.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleDuplicateEmail(EmailAlreadyExistsException e){

       return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

    }

    @ExceptionHandler(AlreadyDeleted_NotExistException.class)
    public ResponseEntity<String>handleAlreadyDeleted(AlreadyDeleted_NotExistException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(CarAlreadyBooked.class)
    public ResponseEntity<String>handleAlreadyBooked(CarAlreadyBooked e){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }

    @ExceptionHandler(CarDoesnotExist.class)
    public ResponseEntity<String>handleCarDoesNotExist(CarDoesnotExist e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UserNotRegistered.class)
    public ResponseEntity<String>handleUserNotRegistered(UserNotRegistered e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(CarInUse.class)
    public ResponseEntity<String>handleCarInUse(CarInUse e){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }

    @ExceptionHandler(ReturnCarNotBooked.class)
    public ResponseEntity<String>handleReturn(ReturnCarNotBooked e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }







}
