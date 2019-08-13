package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable int id) {
        return new User();
    }

    @GetMapping
    public User getUserByName(@RequestParam String name) {
        return new User();
    }

}
