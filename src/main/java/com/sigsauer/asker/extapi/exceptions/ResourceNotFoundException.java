package com.sigsauer.asker.extapi.exceptions;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException() {
        super("Wrong Request URL");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
