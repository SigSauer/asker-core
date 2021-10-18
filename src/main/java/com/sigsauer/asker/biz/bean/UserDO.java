package com.sigsauer.asker.biz.bean;

import com.sigsauer.asker.biz.bean.shared.EntityDO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserDO extends EntityDO {

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "photo")
    private String photo;

    @Column(name = "locale")
    private String locale;

    @Column(name = "created", updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "activity")
    private LocalDateTime activity;




    public UserDO() {
    }

    public UserDO(String username, String email, String password, boolean verified, String photo, String locale) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.verified = verified;
        this.locale = locale;
        this.created = LocalDateTime.now();
        this.activity = LocalDateTime.now();
    }

    public UserDO(String username, String email, String password, boolean verified, String photo, String locale, LocalDateTime created, LocalDateTime activity) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.verified = verified;
        this.locale = locale;
        this.created = created;
        this.activity = LocalDateTime.now();
    }

    public UserDO(UUID id, String username, String email, String password, boolean verified, String photo, String locale, LocalDateTime created, LocalDateTime activity) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.verified = verified;
        this.locale = locale;
        this.created = created;
        this.activity = activity;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getActivity() {
        return activity;
    }

    public void setActivity(LocalDateTime activity) {
        this.activity = activity;
    }

    public void updateActivity() {
        this.activity = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verified=" + verified +
                ", locale='" + locale + '\'' +
                ", created=" + created +
                ", activity=" + activity +
                '}';
    }
}
