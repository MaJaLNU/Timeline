package com.timeline.interfaces;

import com.timeline.model.Movie;

import java.util.List;

/**
 * Created by damma on 22.11.2016.
 */
public interface MovieDAO {
    List<Movie> getAllMovies();

    void deleteMovie(int id);

    void createMovie(Movie movie);

    void editMovie(int id, Movie movieUpdate);
}
