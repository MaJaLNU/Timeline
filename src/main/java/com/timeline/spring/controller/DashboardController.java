package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jan on 29.11.2016.
 */
@Controller
@SessionAttributes("user")
public class DashboardController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping(value = "/dashboard")
    public String getMovieList(Model model) throws IOException {

        if (!model.containsAttribute("user")) {
            return "redirect:/login";
        }

        if (model.containsAttribute("user")) {
            //Get movies from db
            List<Movie> listMovies = movieDAO.getAllMovies();
            Movie movie = new Movie();
            model.addAttribute("listMovies", listMovies);
            model.addAttribute("movieForm", movie);

            return "dashboard";
        } else {
            return "login";
        }
    }

    @GetMapping(value = "/dashboard/{movieID}")
    public String getMovie(@PathVariable("movieID") long id, Model model) {

        if (!model.containsAttribute("user")) {
            return "redirect:/login";
        }

        model.addAttribute("listMovies", movieDAO.getAllMovies());
        Movie movie = movieDAO.getMovie(id);
        model.addAttribute("movie", movie);
        model.addAttribute("movieForm", movie);
        return "dashboard";
    }
}
