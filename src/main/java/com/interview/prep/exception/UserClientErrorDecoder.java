package com.interview.prep.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class UserClientErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new UserNotFoundException("Username/password ");
            case 409:
                return new UserNotFoundException("User already exists");
            case 500:
                return new UserServiceError("User service error");
            default:
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}

