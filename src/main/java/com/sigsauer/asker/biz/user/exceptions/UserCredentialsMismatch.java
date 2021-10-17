package com.sigsauer.asker.biz.user.exceptions;

public class UserCredentialsMismatch extends RuntimeException {

    public UserCredentialsMismatch() {
        super("User email or password mismatch");
    }

    public UserCredentialsMismatch(String message) {
        super(message);
    }
}
