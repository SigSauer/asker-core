package com.sigsauer.asker.biz.exceptions.shared;

import com.sigsauer.asker.extapi.exceptions.ApiException;

import java.util.UUID;

public class EntityConflictException extends ApiException {

    public EntityConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityConflictException(String message) {
        super(message);
    }








    public EntityConflictException(UUID id, String field, String value, String message) {
        super(String.format("Unable to perform operation for Entity with ID = %s. Value %s is duplicated in %s field. : %s", id.toString(), value, field, message));
    }

    public EntityConflictException(UUID id, String operation, String message, Throwable cause) {
        super(String.format("Unable to %s Entity with ID = %s. : %s", operation, id.toString(), message), cause);
    }

    public EntityConflictException(UUID id, String operation, String message) {
        super(String.format("Unable to %s Entity with ID = %s. : %s", operation, id.toString(), message));
    }

    public EntityConflictException(UUID id, Throwable cause) {
        super(String.format("Unable to perform operation for Entity with ID = %s. :", id.toString()), cause);
    }



    public EntityConflictException(Throwable cause) {
        super("Unable to perform operation. :", cause);
    }


    public EntityConflictException() {
        super("Unable to perform operation");
    }
}
