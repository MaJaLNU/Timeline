package com.timeline.spring.controller;

import com.timeline.spring.dao.admin.AdminDAO;
import com.timeline.spring.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by damma on 19.11.2016.
 */

@Controller
@SessionAttributes("admin")
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        ModelAndView model = new ModelAndView("login", "command", new Admin());
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView verifyLogin(HttpServletRequest request, @ModelAttribute("admin") Admin admin) throws SQLException {

        ModelAndView model = new ModelAndView();

        if (!adminDAO.login(admin.getEmail(), admin.getPassword())) {
            model.addObject("loginError", "Login error. Please try again.");
            model.setViewName("login");
            return model;
        }

        model.setViewName("dashboard");
        //set Session with admin
        request.getSession().setAttribute("user", admin);
        return model;
    }
}
