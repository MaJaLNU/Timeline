package com.timeline.controller;

import com.timeline.interfaces.MovieDAO;
import com.timeline.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by damma on 09.11.2016.
 */
@Controller
public class HomeController {

    @Autowired
    private MovieDAO movieService;

    @RequestMapping(value = "/")
    public ModelAndView getMovieList() throws IOException {

        List<String> list = getList();
        System.out.println(list);

        List<Movie> listMovies = movieService.getAllMovies();

        //return back to home.jsp
        ModelAndView model = new ModelAndView("home");
        //model.addObject("lists", list);
        model.addObject("listMovie", listMovies);

        return model;
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
