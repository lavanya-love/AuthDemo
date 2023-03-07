package com.interview.prep.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.interview.prep.exception.UserNotFoundException;
import com.interview.prep.model.User;
import com.interview.prep.model.UserEntity;
import com.interview.prep.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IAMController {
    private final UserServiceImpl userServiceImpl;

    public IAMController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public UserEntity checkUser(@RequestParam String username, @RequestParam String password) throws UserNotFoundException, JsonProcessingException {
         return userServiceImpl.checkUserCredentials(username, password);
    }

    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity user) throws UserNotFoundException {
        return userServiceImpl.createUser(user);
    }

    @GetMapping("/health")
    public String checkuser(){
        return "Healthy";
    }
}
