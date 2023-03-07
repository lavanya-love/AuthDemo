package com.interview.prep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.interview.prep.exception.UserNotFoundException;
import com.interview.prep.model.User;
import com.interview.prep.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity checkUserCredentials(String username, String password) throws UserNotFoundException, JsonProcessingException;
    UserEntity createUser(UserEntity user);

}
