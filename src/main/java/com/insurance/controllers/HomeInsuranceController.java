package com.insurance.controllers;

import com.insurance.models.HomeInsurance;
import com.insurance.models.User;
import com.insurance.services.GenericService;
import com.insurance.utils.enums.SecurityType;
import com.insurance.utils.records.EntityId;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/insurances/home")
public class HomeInsuranceController {

    private final GenericService<HomeInsurance, String> homeInsuranceService;

    @Autowired
    public HomeInsuranceController(GenericService<HomeInsurance, String> homeInsuranceService) {
        this.homeInsuranceService = homeInsuranceService;
    }

//    @GetMapping
//    public String listHomeInsurances(Model model) {
//        model.addAttribute("homeInsurances", homeInsuranceService.findAll());
//        return "homeInsurance/list";
//    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("homeInsurance", new HomeInsurance());
        model.addAttribute("securityTypes", SecurityType.values());
        return "home-insurance/form";
    }

    @PostMapping("/create")
    public String createHomeInsurance(@ModelAttribute("homeInsurance") @Valid HomeInsurance homeInsurance, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "home-insurance/form";
        }
        homeInsurance.setUser((User) session.getAttribute("user"));
        homeInsuranceService.save(homeInsurance);
        return "redirect:/home-insurances";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("homeInsurance", homeInsuranceService.find(id).get());
        model.addAttribute("securityTypes", SecurityType.values());
        return "home-insurance/form";
    }

    @PostMapping("/edit/{id}")
    public String updateHomeInsurance(@PathVariable("id") String id, @Valid @ModelAttribute HomeInsurance homeInsurance, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "home-insurance/edit";
        }
        homeInsurance.setId(UUID.fromString(id));
        homeInsurance.setUser((User) session.getAttribute("user"));
        homeInsuranceService.update(homeInsurance);
        return "redirect:/home-insurances";
    }

    @GetMapping("/delete/{id}")
    public String deleteHomeInsurance(@PathVariable("id") String id) {
        homeInsuranceService.delete(id);
        return "redirect:/home-insurances";
    }
}
