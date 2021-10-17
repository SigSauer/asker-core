package com.sigsauer.asker.extapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException() {
        super("Resource does not exist");
    }

    public ResourceNotFoundException(String resource) {
        super(String.format("Resource %s does not exist", resource));
    }

}
