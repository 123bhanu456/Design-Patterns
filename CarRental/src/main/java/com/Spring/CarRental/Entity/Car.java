package com.Spring.CarRental.Entity;

import com.Spring.CarRental.Entity.state.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {
    @Id
    private String id;
    private CarState carState;
    private String carType;
    private Integer years_old;

    @JsonIgnore
    private State available;
    @JsonIgnore
    private State booked;
    @JsonIgnore
    private State in_use;

    @JsonIgnore
    private State state;

    public Car(@Qualifier("available")State available ,@Qualifier("booked")State booked,@Qualifier("inUse") State in_use){
        this.available=available;
        this.booked=booked;
        this.in_use=in_use;

        state=available;
        carState=CarState.AVAILABLE;

    }

    public State getAvailable() {
        return available;
    }

    public void setAvailable(State available) {
        this.available = available;
    }

    public State getBooked() {
        return booked;
    }

    public void setBooked(State booked) {
        this.booked = booked;
    }

    public State getIn_use() {
        return in_use;
    }

    public void setIn_use(State in_use) {
        this.in_use = in_use;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getYears_old() {
        return years_old;
    }

    public void setYears_old(Integer years_old) {
        this.years_old = years_old;
    }
}
