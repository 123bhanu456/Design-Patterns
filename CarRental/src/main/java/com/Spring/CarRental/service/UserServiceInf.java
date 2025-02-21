package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInf {
    List<User> getAllUsers();
    User addUser(User user);
    void removeUser(String id);
    User getUserById(String id);
}
