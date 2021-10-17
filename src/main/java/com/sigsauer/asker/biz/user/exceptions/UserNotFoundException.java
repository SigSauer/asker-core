package com.sigsauer.asker.biz.user.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String field, String value) {
        super(String.format("User with %s = %s not found", field, value));
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
