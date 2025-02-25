package com.Spring.CarRental.controller;

import com.Spring.CarRental.Entity.User;
import com.Spring.CarRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/User")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public void DeleteUser(@PathVariable String id){
        userService.removeUser(id);
    }

    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

}
