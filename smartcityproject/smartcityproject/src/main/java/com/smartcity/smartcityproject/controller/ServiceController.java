package com.smartcity.smartcityproject.controller;

import com.smartcity.smartcityproject.model.Citizen;
import com.smartcity.smartcityproject.model.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ServiceController {

    private List<Service> services = Arrays.asList(
        new Service("Public Transportation", "Efficient and eco-friendly transportation system across the city.", 
                    "Reduces traffic, lowers pollution, and saves time."),
        new Service("Healthcare", "State-of-the-art healthcare facilities available 24/7.", 
                    "Easy access to emergency care, affordable health services, and better overall health standards."),
        new Service("Waste Management", "Automated and smart waste disposal system.", 
                    "Cleaner streets, reduces landfill waste, and promotes recycling."),
        new Service("Water Management", "Smart water distribution and usage monitoring.", 
                    "Efficient water usage, conservation, and low-cost water supply."),
        new Service("Security & Surveillance", "Advanced city surveillance system for public safety.", 
                    "Reduced crime rate, faster emergency responses, and safer streets.")
    );
    
    @GetMapping("/services")
    public String showServices(Model model) {
        model.addAttribute("services", services);
        return "services";  
    }
    
    @PostMapping("/opt-in-service")
    public String optInService(@RequestParam String citizenName, @RequestParam Long serviceId, Model model) {
        if (serviceId >= 0 && serviceId < services.size()) {
            Service selectedService = services.get(serviceId.intValue());
            Citizen citizen = new Citizen(citizenName, selectedService);

            selectedService.addCitizen(citizen);
        }

        return "redirect:/services";
    }
}
