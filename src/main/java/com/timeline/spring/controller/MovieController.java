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
import java.sql.Date;
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

    //Displaying new movie-from
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public void newMovie(@ModelAttribute Movie movie, ModelMap model) {
        model.addAttribute("title", movie.getTitle());
        model.addAttribute("description", movie.getDescription());
        model.addAttribute("director", movie.getDirector());
        model.addAttribute("image", movie.getImage());
        model.addAttribute("length", movie.getLength());
        model.addAttribute("rating", movie.getRating());
        model.addAttribute("releasedate", movie.getReleasedate());
        model.addAttribute("youtube", movie.getYoutube());

        movieDAO.createMovie(movie);
    }

    //inserting or updating movie
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
    public String saveMovie(@RequestParam("title") String title,
                            @RequestParam("rating") double rating,
                            @RequestParam("releasedate") Date releasedate,
                            @RequestParam("director") String director,
                            @RequestParam("length") String length,
                            @RequestParam("youtube") String youtube,
                            @RequestParam("description") String description,
                            @RequestParam("image") String image,
                            ModelMap modelMap) {

        modelMap.addAttribute("title", title);
        modelMap.addAttribute("description", description);
        modelMap.addAttribute("director", director);
        modelMap.addAttribute("image", image);
        modelMap.addAttribute("length", length);
        modelMap.addAttribute("rating", rating);
        modelMap.addAttribute("releasedate", releasedate);
        modelMap.addAttribute("youtube", youtube);

        if (title == null || description == null || director == null || image == null || length == null || (Double) rating == null || releasedate == null || youtube == null) {
            modelMap.addAttribute("error", "All fields are required!");
        } else {
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setDescription(description);
            movie.setDirector(director);
            movie.setImage(image);
            movie.setLength(length);
            movie.setRating(rating);
            movie.setReleasedate(releasedate);
            movie.setYoutube(youtube);

            movieDAO.createMovie(movie);
            modelMap.addAttribute("success", "Item successfully added!");
        }
        return "create";
    }


    //deleting movie
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
    public ModelAndView deleteContact(@RequestParam("movie") long movieId) {
        movieDAO.deleteMovie(movieId);
        return new ModelAndView("redirect:/");
    }

}
