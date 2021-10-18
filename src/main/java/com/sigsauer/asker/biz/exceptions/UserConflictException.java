package com.sigsauer.asker.biz.exceptions;

import com.sigsauer.asker.biz.exceptions.shared.EntityConflictException;

import java.util.UUID;


public class UserConflictException extends EntityConflictException {

    public UserConflictException(UUID id, String field, String value, String message) {
        super(String.format("Unable to perform operation for User with ID = %s. Value %s is duplicated in %s field. : %s", id.toString(), value, field, message));
    }

    public UserConflictException(UUID id, String operation, String message, Throwable cause) {
        super(String.format("Unable to %s User with ID = %s. : %s. : ", operation, id.toString(), message), cause);
    }

    public UserConflictException(UUID id, String operation, Throwable cause) {
        super(String.format("Unable to %s User with ID = %s. : ", operation, id.toString()), cause);
    }

    public UserConflictException(UUID id, String operation, String message) {
        super(String.format("Unable to %s User with ID = %s. : %s", operation, id.toString(), message));
    }

    public UserConflictException(String operation, Throwable cause) {
        super(String.format("Unable to %s User. : ", operation), cause);
    }


    public UserConflictException(String operation, String message) {
        super(String.format("Unable to %s User. : %s", operation, message));
    }

    public UserConflictException(UUID id, Throwable cause) {
        super(String.format("Unable to perform operation for User with ID = %s. :", id.toString()), cause);
    }

    public UserConflictException(Throwable cause) {
        super("Unable to perform operation for User. :", cause);
    }

    public UserConflictException(String message) {
        super(message);
    }


    public UserConflictException() {
        super("Unable to perform operation for User");
    }
}
