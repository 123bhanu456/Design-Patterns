package com.Spring.CarRental.service;

import com.Spring.CarRental.Entity.User;
import com.Spring.CarRental.Repo.UserRepo;
import com.Spring.CarRental.exceptions.AlreadyDeleted_NotExistException;
import com.Spring.CarRental.exceptions.EmailAlreadyExistsException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInf{
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public List<User> getAllUsers(){
       return userRepo.findAll();

    }

    @Override
    @Transactional
    public User addUser(User user){
        try {
             return userRepo.save(user);
        } catch (DuplicateKeyException e) {
            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
        }

    }

    @Override
    @Transactional
    public void removeUser(String id) {
        if(!userRepo.existsById(id)){
            throw new AlreadyDeleted_NotExistException("user with id"+id+" might already be deleted / doesn't exist");
        }
            userRepo.deleteById(id);

    }

    @Override
    public User getUserById(String id) {
        if(!userRepo.existsById(id)){
            throw new AlreadyDeleted_NotExistException("user with id"+id+" might already be deleted / doesn't exist");
        }
        return userRepo.findById(id).get();
    }


}
