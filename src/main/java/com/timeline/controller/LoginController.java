package com.timeline.controller;

import com.timeline.model.Admin;
import com.timeline.utils.admin.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by damma on 19.11.2016.
 */

@Controller
public class LoginController {

    //@Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "WEB-INF/pages/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam int id, @RequestParam String password, Model model) {
        Admin admin = adminService.loginAdmin(id, password);

        if (admin == null) {
            model.addAttribute("loginError", "Login error. Pleas try again.");
            return "WEB-INF/pages/login";
        }
        return "redirect:/";
    }


}
