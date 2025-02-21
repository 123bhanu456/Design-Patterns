package com.Spring.CarRental.Entity.state;

import com.Spring.CarRental.Entity.Car;
import org.springframework.stereotype.Component;

@Component
public class InUse implements State {
    @Override
    public void Book(Car car) {

    }

    @Override
    public void return_back(Car car) {

    }
}
