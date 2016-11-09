package com.timeline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by damma on 09.11.2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home(){
        return "test";
    }
}
