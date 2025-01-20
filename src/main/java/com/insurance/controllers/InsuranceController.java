package com.insurance.controllers;

import com.insurance.models.Insurance;
import com.insurance.services.InsuranceService;
import com.insurance.utils.records.EntityId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/insurances")
public class InsuranceController {
    private final InsuranceService<Insurance, String> insuranceService;

    @Autowired
    public InsuranceController(InsuranceService<Insurance, String> insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public String listAllInsurances(Model model) {
        model.addAttribute("insurances", insuranceService.getAll());
        return "home";
    }

//    @GetMapping("/create")
//    public String showCreateForm(@RequestParam("type") String type, Model model) {
//        Insurance insurance;
//        switch (type.toLowerCase()) {
//            case "home":
//                insurance = new HomeInsurance();
//                break;
//            case "health":
//                insurance = new HealthInsurance();
//                break;
//            case "vehicle":
//                insurance = new VehicleInsurance();
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown insurance type: " + type);
//        }
//        model.addAttribute("insurance", insurance);
//        model.addAttribute("type", type);
//        return "insurance/create";
//    }
//
//    @PostMapping("/create")
//    public String createInsurance(@Valid @ModelAttribute Insurance insurance, BindingResult result, @RequestParam("type") String type) {
//        if (result.hasErrors()) {
//            return "insurance/create";
//        }
//        insuranceService.save(insurance);
//        return "redirect:/insurances";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable("id") EntityId id, Model model) {
//        Insurance insurance = insuranceService.findById(id);
//        model.addAttribute("insurance", insurance);
//        model.addAttribute("type", insurance.getClass().getSimpleName().toLowerCase());
//        return "insurance/edit";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String updateInsurance(@PathVariable("id") EntityId id, @Valid @ModelAttribute Insurance insurance, BindingResult result) {
//        if (result.hasErrors()) {
//            return "insurance/edit";
//        }
//        insuranceService.update(id, insurance);
//        return "redirect:/insurances";
//    }
////
    @GetMapping("/delete/{id}")
    public String deleteInsurance(@PathVariable("id") String id) {
        insuranceService.delete(id);
        return "redirect:/insurances";
    }
}
