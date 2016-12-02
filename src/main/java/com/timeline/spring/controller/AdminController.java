package com.timeline.spring.controller;

import com.timeline.spring.dao.admin.AdminDAO;
import com.timeline.spring.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created by damma on 19.11.2016.
 */

@Controller
@SessionAttributes("user")
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;

    @GetMapping(value = "/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView("login", "command", new Admin());
    }

    @PostMapping(value = "/login")
    public ModelAndView verifyLogin(@ModelAttribute Admin admin) throws SQLException {

        ModelAndView model = new ModelAndView();

        if (!adminDAO.login(admin.getEmail(), admin.getPassword())) {
            model.addObject("loginError", "Login error. Please try again.");
            model.setViewName("login");
            return model;
        }

        model.setViewName("redirect:/dashboard");
        //set Session with admin
        model.addObject("user", admin);

        return model;
    }
}
