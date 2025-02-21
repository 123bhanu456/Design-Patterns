package com.Spring.CarRental.Repo;

import com.Spring.CarRental.Entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends MongoRepository<Car,String> {

}
