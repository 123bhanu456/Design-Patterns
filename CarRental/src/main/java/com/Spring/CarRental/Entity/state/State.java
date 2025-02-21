package com.Spring.CarRental.Entity.state;

import com.Spring.CarRental.Entity.Car;

public interface State {

    void Book(Car car);
    void return_back(Car car);
}
