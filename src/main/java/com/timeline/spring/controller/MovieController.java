package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by damma on 09.11.2016.
 */
@Controller
public class MovieController {

    @Autowired
    private MovieDAO movieDAO;

    // Display all movies
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getMovieList() throws IOException {

        ModelAndView model = new ModelAndView();
        //Get movies from db
        List<Movie> listMovies = movieDAO.getAllMovies();
        model.addObject("listMovies", listMovies);
        model.setViewName("home");

        return model;
    }

    //inserting or updating movie
    @PostMapping(value = "/saveMovie")
    public String saveMovie(@ModelAttribute("movieForm") Movie movie, BindingResult result, Model model) {

        model.addAttribute("title", movie.getTitle());
        model.addAttribute("description", movie.getDescription());
        model.addAttribute("director", movie.getDirector());
        model.addAttribute("hiddenImage", movie.getImage());
        model.addAttribute("length", movie.getRating());
        model.addAttribute("rating", movie.getRating());
        model.addAttribute("releasedate", movie.getReleasedate());
        model.addAttribute("youtube", movie.getYoutube());

        if (movie.getTitle() == null || movie.getDescription() == null || movie.getDirector() == null || movie.getImage() == null ||
                movie.getLength() == null || movie.getRating() == null || movie.getReleasedate() == null ||
                movie.getYoutube() == null) {
            model.addAttribute("error", "All fields are required!");
            return "redirect:/dashboard/" + movie.getId();
        } else {
            Movie m = movieDAO.createOrUpdateMovie(movie);
            model.addAttribute("success", "Item successfully added!");
            return "redirect:/dashboard/" + m.getId();
        }
    }


    //deleting movie
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
    public ModelAndView deleteContact(@RequestParam("movie") long movieId) {
        movieDAO.deleteMovie(movieId);
        return new ModelAndView("redirect:/");
    }

}
