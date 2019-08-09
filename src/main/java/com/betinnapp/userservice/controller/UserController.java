package com.betinnapp.userservice.controller;

import com.betinnapp.userservice.model.User;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
