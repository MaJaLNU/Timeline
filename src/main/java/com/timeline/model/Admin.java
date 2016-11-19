package com.timeline.model;

/**
 * Created by damma on 19.11.2016.
 */
public class Admin {

    private String mail;
    private String password;

    public Admin(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
