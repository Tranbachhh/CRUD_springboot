package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userServiceImpl implements  userService{

    @Autowired
    private userRepository userRepository;

    @Override
    public List<User> getListUser(){
        return userRepository.getListUser();
    }

    @Override
    public Optional<User> getUserById(long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser;
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }
}
