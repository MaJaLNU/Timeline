package com.timeline.spring.model;

import org.springframework.stereotype.Component;

/**
 * Created by damma on 19.11.2016.
 */
@Component
public class Admin {

    private long id;
    private String email;
    private String password;

    public Admin(int id, String mail, String password) {
        this.id = id;
        this.email = mail;
        this.password = password;
    }

    public Admin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
