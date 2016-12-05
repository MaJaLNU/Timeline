package com.timeline.spring.controller;

import com.timeline.spring.dao.movie.MovieDAO;
import com.timeline.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping(value = "/")
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
    public String saveMovie(@ModelAttribute("movieForm") Movie movie, Model model) {
        System.out.println("Entered /savemovie");
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
            List<Movie> moviesList = movieDAO.getAllMovies();
            model.addAttribute("listMovies", moviesList);
            Movie m = movieDAO.createOrUpdateMovie(movie);
            model.addAttribute("movieid", m.getId());
            model.addAttribute("success", "Item successfully saved/updated!");
            return "redirect:/dashboard/" + m.getId();
        }
    }


    //deleting movie
    @PostMapping(value = "/deleteMovie/{movieID}")
    public String deleteMovie(@PathVariable("movieID") long id, @ModelAttribute("movieForm") Movie movie, BindingResult result, Model model) {
        movieDAO.deleteMovie(id);
        model.addAttribute("listMovies", movieDAO.getAllMovies());
        model.addAttribute("deleteError", "Error while deleting.");
        return "redirect:/dashboard";
    }

}
