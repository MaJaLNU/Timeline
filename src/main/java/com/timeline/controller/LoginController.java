package com.timeline.controller;

import com.timeline.model.Admin;
import com.timeline.utils.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by damma on 19.11.2016.
 */

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam int id, @RequestParam String password, HttpSession session, Model model) {
        Admin admin = adminService.loginAdmin(id, password);

        if (admin == null) {
            model.addAttribute("loginError", "Login error. Pleas try again.");
            return "login";
        }
        session.setAttribute("loggedInAdmin", admin);
        return "redirect:/";
    }


}
