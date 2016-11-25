package com.timeline.spring.controller;

import com.timeline.spring.dao.admin.AdminService;
import com.timeline.spring.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by damma on 19.11.2016.
 */

@Controller
public class LoginController {

    //@Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam Map<String, String> reqPara) {

        String mail = reqPara.get("adminMail");
        String password = reqPara.get("adminPassword");

        ModelAndView model = new ModelAndView("dashboard");

        Admin admin = adminService.loginAdmin(mail, password);

        if (admin == null) {
            model.addObject("loginError", "Login error. Pleas try again.");
            return "login";
        }
        return "redirect:/";
    }


}
