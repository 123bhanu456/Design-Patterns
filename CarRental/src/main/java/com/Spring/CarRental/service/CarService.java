package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.Car;
import com.Spring.CarRental.Entity.CarState;
import com.Spring.CarRental.Repo.CarRepo;
import com.Spring.CarRental.exceptions.AlreadyDeleted_NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceInf{

    CarRepo carRepo;
    @Autowired
    public CarService(CarRepo carRepo){
        this.carRepo=carRepo;
    }
    @Override
    public List<Car> getAllCar() {
        return carRepo.findAll();
    }

    @Override
    @Transactional
    public Car addCar(Car car) {
        return carRepo.insert(car);
    }

    @Override
    public Car getCarById(String id) {
        if(!carRepo.existsById(id)){
            throw new AlreadyDeleted_NotExistException("Car with id "+id+" already Deleted / Doesn't exist");
        }
        return carRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void removeCar(String id) {

        if(!carRepo.existsById(id)){
            throw new AlreadyDeleted_NotExistException("Car with id "+id+" already Deleted / Doesn't exist");
        }
        carRepo.deleteById(id);
    }

    @Override
    public CarState getCarState(String id) {
        Optional<Car> car;
        if(!carRepo.existsById(id)){
            throw new AlreadyDeleted_NotExistException("Car with id "+id+" already Deleted / Doesn't exist");
        }
        car=carRepo.findById(id);

        return car.get().getCarState();

    }

    @Override
    @Transactional
    public void updateCar(Car car) {
        carRepo.save(car);
    }
}
