package com.sigsauer.asker.biz.user.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String field, String value) {
        super(String.format("User with field %s = %s already exist ", field, value));
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }

}
