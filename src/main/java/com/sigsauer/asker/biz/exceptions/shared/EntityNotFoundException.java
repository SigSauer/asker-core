package com.sigsauer.asker.biz.exceptions.shared;

import com.sigsauer.asker.extapi.exceptions.ApiException;

public class EntityNotFoundException extends ApiException {

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
