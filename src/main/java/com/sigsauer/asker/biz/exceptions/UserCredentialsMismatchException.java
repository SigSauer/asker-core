package com.sigsauer.asker.biz.exceptions;

public class UserCredentialsMismatchException extends RuntimeException {

    public UserCredentialsMismatchException() {
        super("User email or password mismatch");
    }

    public UserCredentialsMismatchException(String message) {
        super(message);
    }

    public UserCredentialsMismatchException(UserCredentialsMismatchException other) {
        super(other);
    }
}
