package com.betinnapp.userservice.service;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.model.dto.UserDTO;
import com.betinnapp.userservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserDTO save(User user) {
        userRepository.save(user);
        UserDTO userDTO = mapper.convertValue(user, UserDTO.class);
        return userDTO;
    }

    @Transactional
    public UserDTO create(User user){
        UUID random = UUID.randomUUID();
        user.setToken(random);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        UserDTO userDTO = mapper.convertValue(user, UserDTO.class);
        return userDTO;
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public UserDTO findUserByToken(UUID token){
        User user = userRepository.findByToken(token);
        UserDTO userDTO = mapper.convertValue(user, UserDTO.class);
        return userDTO;
    }
}
