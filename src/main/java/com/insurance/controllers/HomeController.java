package com.insurance.controllers;

import com.insurance.models.Test;
import com.insurance.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private TestRepository testRepository;

    @GetMapping("/")
    public ModelAndView home() {
        testRepository.save(new Test());
        ModelAndView mav = new ModelAndView("home");
//        mav.addObject("message", "Welcome to Spring 6 MVC with JPA and JSP!");
        return mav;
    }
}