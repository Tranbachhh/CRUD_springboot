package com.example.demo.controllers;
import com.example.demo.entity.User;
import com.example.demo.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class userController {
    @Autowired
    private userService userService;
    @GetMapping("")
    public ResponseEntity<?> getUsers(){
        List<User> users =  userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable long id){
        Optional<User> userByID = userService.getUserById(id);
        if(userByID.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> creteUser(@RequestBody User data){
        for (User user : userService.getListUser() ) {
            if(data.getName().equals(user.getName()) && data.getEmail().equals(user.getEmail()))
                return ResponseEntity.ok("Tài khoản đã tồn tại");
        }
        userService.createUser(data);
        return ResponseEntity.ok(data);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id){
        for (User user : userService.getListUser() ) {
            if(user.getId() == id){
                userService.deleteUserById(id);
                return ResponseEntity.ok("Đã xoá thành công");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
