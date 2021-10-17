package com.sigsauer.asker.api.user.bean;

public class UserAO {

    private String id;
    private String username;
    private String email;
    private boolean verified;
    private String photo;
    private String locale;

    public UserAO() {
    }

    public UserAO(String id, String username, String email, boolean verified, String photo, String locale) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.verified = verified;
        this.photo = photo;
        this.locale = locale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "UserAO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", verified=" + verified +
                ", photo='" + photo + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
