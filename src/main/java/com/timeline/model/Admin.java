package com.timeline.model;

/**
 * Created by damma on 19.11.2016.
 */
public class Admin {

    private int id;
    private String mail;
    private String password;

    public Admin(int id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
