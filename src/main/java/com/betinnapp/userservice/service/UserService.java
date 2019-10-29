package com.betinnapp.userservice.service;

import com.betinnapp.userservice.model.User;
import com.betinnapp.userservice.model.dto.UserDTO;
import com.betinnapp.userservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(ObjectMapper objectMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDTO save(User user) {
        userRepository.save(user);
        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);

        return userDTO;
    }

    @Transactional
    public UserDTO create(User user) {
        UUID random = UUID.randomUUID();
        user.setToken(random);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);
        return userDTO;
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public UserDTO findUserByToken(UUID token) {
        User user = userRepository.findByToken(token);
        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);

        return userDTO;
    }

    @Transactional
    public UserDTO updateUser(UUID token, User alterations) {
        User user = userRepository.findByToken(token);
        User alteredUser = userRepository.save(mergeAlterations(user,alterations));

        return objectMapper.convertValue(alteredUser, UserDTO.class);
    }

    private User mergeAlterations(User user, User alterations) {
        user.setFirstName(alterations.getFirstName());
        user.setLastName(alterations.getLastName());
        user.setShortName(alterations.getShortName());
        user.setEmail(alterations.getEmail());
        user.setBirthDate(alterations.getBirthDate());
        user.setWork(alterations.getWork());

        return user;
    }

}
