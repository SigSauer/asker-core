package com.sigsauer.asker.api.user.bean;

public class UserCredentialsAO {

    private String email;
    private String password;


    public UserCredentialsAO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
