package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping(path = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(value = "uuid") UUID id) {
        userService.delete(id);
    }

    @PutMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
}
