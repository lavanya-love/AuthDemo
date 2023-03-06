package com.interview.prep.service;

import com.interview.prep.exception.UserNotFoundException;
import com.interview.prep.model.User;
import com.interview.prep.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<Object> checkUserCredentials(String username, String password) throws UserNotFoundException;
    String getHealth();
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
