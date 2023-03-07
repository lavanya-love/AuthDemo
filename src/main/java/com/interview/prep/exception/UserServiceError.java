package com.interview.prep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserServiceError extends Exception{
    public UserServiceError(String message) {
        super(message);
    }

}
