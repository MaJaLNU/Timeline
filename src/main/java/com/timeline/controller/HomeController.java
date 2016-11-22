package com.timeline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damma on 09.11.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView getMovieList() {

        List<String> list = getList();

        System.out.println(list);

        //return back to home.jsp
        ModelAndView model = new ModelAndView("home");
        model.addObject("lists", list);

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
