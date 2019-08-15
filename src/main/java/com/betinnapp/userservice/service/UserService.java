package com.betinnapp.userservice.service;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }
}
