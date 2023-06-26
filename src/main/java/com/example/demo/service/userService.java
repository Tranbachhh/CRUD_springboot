package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface userService {


    public List<User> getListUser();

    public Optional<User> getUserById(long id);

    public User createUser(User user);

    public void deleteUserById(long id);
}
