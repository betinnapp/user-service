package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.model.UserDTO;
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
    public UserDTO getUserById() {
        return new UserDTO();
    }

    @PostMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping(path = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(value = "uuid") UUID id) {
        userService.delete(id);
    }

    @PutMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO updateUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
}
