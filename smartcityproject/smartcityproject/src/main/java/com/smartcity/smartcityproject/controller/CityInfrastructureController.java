package com.smartcity.smartcityproject.controller;

import com.smartcity.smartcityproject.model.CityInfrastructure;
import com.smartcity.smartcityproject.service.CityInfrastructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CityInfrastructureController {

    @Autowired
    private CityInfrastructureService cityInfrastructureService;

    
    @GetMapping("/add-infrastructure")
    public String showAddInfrastructureForm(Model model) {
        model.addAttribute("cityInfrastructure", new CityInfrastructure());
        return "add-infrastructure";
    }

    
    @PostMapping("/add-infrastructure")
    public String addInfrastructure(@ModelAttribute("cityInfrastructure") CityInfrastructure cityInfrastructure) {
        cityInfrastructureService.addInfrastructure(cityInfrastructure);
        return "redirect:/infrastructure"; 
    }

    
    @GetMapping("/infrastructure")
    public String viewAllInfrastructure(Model model) {
        model.addAttribute("infrastructures", cityInfrastructureService.getAllInfrastructure());
        return "infrastructure"; 
    }
}
