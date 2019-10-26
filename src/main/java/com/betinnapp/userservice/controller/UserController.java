package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.model.dto.UserDTO;
import com.betinnapp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping(path = "/me")
    public UserDTO getUserById(@RequestHeader(name = "authorization") String authorization) {
        UUID authToken =  UUID.fromString(authorization);
        return userService.findUserByToken(authToken);
    }

    @PutMapping(path = "/me")
    public UserDTO putUserById(@RequestHeader(name = "authorization" ) String authorization, @RequestBody User user) {
        UUID authToken =  UUID.fromString(authorization);
        return userService.updateUser(authToken, user);
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
