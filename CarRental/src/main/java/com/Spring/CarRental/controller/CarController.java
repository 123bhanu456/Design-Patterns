package com.Spring.CarRental.controller;

import com.Spring.CarRental.Entity.Car;
import com.Spring.CarRental.Entity.CarState;
import com.Spring.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService=carService;
    }

    @GetMapping("/Cars")
    public List<Car> getAllCars(){
        return carService.getAllCar();
    }

    @GetMapping("/Car/{id}")
    public Car getCarById(@PathVariable String id){
        return carService.getCarById(id);
    }

    @GetMapping("/CarState/{id}")
    public CarState getStateById(@PathVariable String id){
        return carService.getCarState(id);
    }

    @PostMapping("/Car")
        public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @PostMapping("/Car/{id}")
    public void removeCar(@PathVariable String id){
        carService.removeCar(id);
    }





}
