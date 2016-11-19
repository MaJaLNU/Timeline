package com.timeline.model;


import java.sql.Date;

/**
 * Created by damma on 19.11.2016.
 */
public class Movie {

    private int id;
    private String title;
    private String picture;
    private double rating;
    private Date release;
    private Date length;
    private String director;
    private String youtube;
    private String description;

    public Movie(int id, String title, String picture, double rating, Date release, Date length, String director, String youtube, String description) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.rating = rating;
        this.release = release;
        this.length = length;
        this.director = director;
        this.youtube = youtube;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Date getLength() {
        return length;
    }

    public void setLength(Date length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
