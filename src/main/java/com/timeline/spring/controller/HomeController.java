package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by damma on 09.11.2016.
 */
@Controller
public class HomeController {

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getMovieList() throws IOException {
        System.out.println("IM HomeController - getMovies");

        ModelAndView model = new ModelAndView();
        //Get movies from db
        List<Movie> listMovies = movieDAO.getAllMovies();
        System.out.println("Liste aus db: " + listMovies.toString());
        model.addObject("listMovies", listMovies);
        model.setViewName("home");

        //List<String> list = getList();
        //model.addObject("listMovies", list);
        //System.out.println(list);

        return model;
    }

    //Displaying new movie-from
    @RequestMapping(value = "/newMovie", method = RequestMethod.POST)
    public void newMovie(@ModelAttribute Movie movie, ModelMap model) {
        model.addAttribute("title", movie.getTitle());
        model.addAttribute("description", movie.getDescription());
        model.addAttribute("director", movie.getDirector());
        model.addAttribute("image", movie.getImage());
        model.addAttribute("length", movie.getLength());
        model.addAttribute("rating", movie.getRating());
        model.addAttribute("releasedate", movie.getReleasedate());
        model.addAttribute("youtube", movie.getYoutube());

        System.out.println(movie.getDescription());
        movieDAO.createMovie(movie);
    }

    //inserting movie
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
    public ModelAndView saveMovie(@ModelAttribute Movie movie) {
        movieDAO.createMovie(movie);
        return new ModelAndView("redirect:/");
    }

    //updating movie
    @RequestMapping(value = "/updateMovie", method = RequestMethod.PUT)
    public ModelAndView updateMovie(@ModelAttribute Movie movie) {
        movieDAO.editMovie(movie);
        return new ModelAndView("redirect:/");
    }

    //deleting movie
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
    public ModelAndView deleteContact(@RequestParam("movie") long movieId) {
        movieDAO.deleteMovie(movieId);
        return new ModelAndView("redirect:/");
    }

}
