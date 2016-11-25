package com.timeline.spring.dao.movie;

import com.timeline.spring.model.Movie;

import java.util.List;

/**
 * Created by damma on 22.11.2016.
 */
public interface MovieDAO {
    List<Movie> getAllMovies();

    void deleteMovie(long id);
    void createMovie(Movie movie);

    void editMovie(Movie movieUpdate);
}
