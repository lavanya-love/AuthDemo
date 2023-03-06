package com.interview.prep.service;

import com.interview.prep.exception.UserNotFoundException;
import com.interview.prep.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserServiceClient userServiceClient;
    @Override
    public Optional<Object> checkUserCredentials(String username, String password) throws UserNotFoundException {
        System.out.println(userServiceClient.checkUserCredentials(username,password).toString());
        Optional<Object> user = userServiceClient.checkUserCredentials(username,password);
        if(user.isEmpty()) {
            log.info("Username does not exist");
            throw new UserNotFoundException("Username does not exist");
        }
        return user;
    }

    @Override
    public String getHealth() {
        return userServiceClient.getHealth();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userServiceClient.getAllUsers();
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userServiceClient.createUser(user);
    }
}
