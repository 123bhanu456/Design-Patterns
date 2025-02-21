package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.Car;
import com.Spring.CarRental.Entity.CarState;

import java.util.List;
import java.util.Optional;

public interface CarServiceInf {
    List<Car> getAllCar();
    Car addCar(Car car);
    Car getCarById(String id);
    void removeCar(String id);
    CarState getCarState(String id);
    Car updateCar(Car car);


}
