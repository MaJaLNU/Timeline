package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jan on 29.11.2016.
 */
@Controller
public class DashboardController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping(value = "/dashboard")
    public String getMovieList(Model model) throws IOException {

        //Get movies from db
        List<Movie> listMovies = movieDAO.getAllMovies();
        Movie movie = new Movie();
        model.addAttribute("listMovies", listMovies);
        model.addAttribute("movieForm", movie);

        return "/dashboard";
    }

    @GetMapping(value = "/dashboard/{movieID}")
    public String getMovie(@PathVariable("movieID") long id, Model model) {
        model.addAttribute("listMovies", movieDAO.getAllMovies());
        Movie movie = movieDAO.getMovie(id);
        model.addAttribute("movie", movie);
        model.addAttribute("movieForm", movie);
        return "/dashboard";
    }
}
