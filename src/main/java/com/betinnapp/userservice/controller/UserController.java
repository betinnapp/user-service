package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @GetMapping(path = "/me")
    public User getUserById() {
        return new User();
    }

}
