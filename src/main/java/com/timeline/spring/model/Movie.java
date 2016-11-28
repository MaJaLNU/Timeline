package com.timeline.spring.model;


import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Date;

/**
 * Created by damma on 19.11.2016.
 */
public class Movie {

    private long id;
    private String title;
    private String image;
    private double rating;
    private Date releasedate;
    private String length;
    private String director;
    private String youtube;
    private String description;

    public Movie(long id, String title, String picture, double rating, Date release, String length, String director, String youtube, String description) {
        this.id = id;
        this.title = title;
        this.image = picture;
        this.rating = rating;
        this.releasedate = release;
        this.length = length;
        this.director = director;
        this.youtube = youtube;
        this.description = description;
    }

    public  Movie(){}

    @ModelAttribute
    public Movie movie() {
        return new Movie();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
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
