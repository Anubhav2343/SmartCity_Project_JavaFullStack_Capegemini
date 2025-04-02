package com.smartcity.smartcityproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smartcity.smartcityproject.model.Citizen;
import com.smartcity.smartcityproject.service.CitizenService;

@Controller
public class CitizenController {
	@Autowired
    private CitizenService citizenService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("citizens", citizenService.getAllCitizens());
        return "index";  
    }

    @GetMapping("/register")
    public String showForm() {
        return "register";  
    }

    @PostMapping("/register")
    public String registerCitizen(Citizen citizen) {
        citizenService.saveCitizen(citizen);
        return "redirect:/";  
    }
    
    @GetMapping("/citizens")
    public String viewCitizens(Model model) {
        model.addAttribute("citizens", citizenService.getAllCitizens());
        return "citizens";  
    }
}
