package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by damma on 09.11.2016.
 */

public class HomeController {

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getMovieList() throws IOException {
        System.out.println("IM HomeController - getMovies");

        ModelAndView model = new ModelAndView();
        //Get movies from db
        //List<Movie> listMovies = movieDAO.getAllMovies();
        //System.out.println("Liste aus db: " + listMovies.toString());
        //model.addObject("listMovies", listMovies);
        model.setViewName("home");

        List<String> list = getList();
        model.addObject("listMovies", list);
        //System.out.println(list);

        return model;
    }

    //Displaying new movie-from
    @RequestMapping(value = "/newMovie", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Movie newMovie = new Movie();
        model.addObject("movie", newMovie);
        model.setViewName("MovieForm");
        return model;
    }

    //inserting movie
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
    public ModelAndView saveMovie(@ModelAttribute Movie movie) {
        movieDAO.createMovie(movie);
        return new ModelAndView("redirect:/");
    }

    //updating movie
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
    public ModelAndView updateMovie(@ModelAttribute Movie movie) {
        movieDAO.editMovie(movie);
        return new ModelAndView("redirect:/");
    }

    //deleting movie
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.POST)
    public ModelAndView deleteContact(@RequestParam("movie") long movieId) {
        movieDAO.deleteMovie(movieId);
        return new ModelAndView("redirect:/");
    }

    private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List 1");
        list.add("List 2");
        list.add("List 3");

        return list;
    }
}
