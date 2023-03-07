package com.interview.prep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.interview.prep.exception.UserNotFoundException;
import com.interview.prep.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserServiceClient userServiceClient;
    @Override
    public UserEntity checkUserCredentials(String username, String password) throws UserNotFoundException {
        List<UserEntity> user = userServiceClient.checkUserCredentials(username,password);
         if(user.get(0).getPassword().equals(password)){
            return user.get(0);
        }
        else{
            log.info("Username/password does not match");
            throw new UserNotFoundException("Username/password does not match");
        }

    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userServiceClient.createUser(user);
    }
}
