package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jan on 29.11.2016.
 */
@Controller
public class DashboardController {

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView getMovieList() throws IOException {

        ModelAndView model = new ModelAndView();
        //Get movies from db
        List<Movie> listMovies = movieDAO.getAllMovies();
        model.addObject("listMovies", listMovies);
        model.setViewName("dashboard");

        return model;
    }
}
