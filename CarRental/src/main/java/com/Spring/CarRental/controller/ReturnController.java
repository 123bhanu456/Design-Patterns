package com.Spring.CarRental.controller;

import com.Spring.CarRental.service.ReturnService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnController {

    private ReturnService returnService;

    public ReturnController (ReturnService returnService){
        this.returnService=returnService;
    }
    @PostMapping("/return/{BookingId}")
    public double ret(@PathVariable String BookingId){
        return returnService.returnCar(BookingId);
    }
}
