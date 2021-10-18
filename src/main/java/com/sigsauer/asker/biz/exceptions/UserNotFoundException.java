package com.sigsauer.asker.biz.exceptions;


import com.sigsauer.asker.biz.exceptions.shared.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String field, String value) {
        super(String.format("Unable to find User by %s = %s. ", field, value));
    }

    public UserNotFoundException(String field, String value, Throwable cause) {
        super(String.format("Unable to find User by %s = %s. : ", field, value), cause);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
