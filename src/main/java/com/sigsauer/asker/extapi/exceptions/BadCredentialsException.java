package com.sigsauer.asker.extapi.exceptions;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException() {
        super("Invalid credentials");
    }

    public BadCredentialsException(String message) {
        super(message);
    }
}
