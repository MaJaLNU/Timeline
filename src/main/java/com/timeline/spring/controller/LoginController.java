package com.timeline.spring.controller;

import com.timeline.spring.dao.admin.AdminDAO;
import com.timeline.spring.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created by damma on 19.11.2016.
 */

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private AdminDAO adminDAO;

    @GetMapping(value = "/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView("login", "command", new Admin());
    }

    @PostMapping(value = "/login")
    public ModelAndView verifyLogin(@ModelAttribute Admin admin) throws SQLException {

        if (!adminDAO.login(admin.getEmail(), admin.getPassword())) {
            ModelAndView model = new ModelAndView("login", "command", new Admin());
            model.addObject("loginError", "Login error. Please try again.");
            return model;
        }

        ModelAndView model = new ModelAndView("redirect:/dashboard");
        //set Session with admin
        model.addObject("user", admin);

        return model;
    }

    @GetMapping(value = "/logout")
    public String logout(SessionStatus status) throws SQLException {

        status.setComplete();
        return "redirect:/";
    }
}
