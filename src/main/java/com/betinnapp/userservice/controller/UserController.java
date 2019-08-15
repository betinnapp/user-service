package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/me")
    public User getUserById() {
        return new User();
    }

    @PostMapping(path = "/")
    public String createUser(){
        userService.create(new User());
        return "Ok";
    }

}
