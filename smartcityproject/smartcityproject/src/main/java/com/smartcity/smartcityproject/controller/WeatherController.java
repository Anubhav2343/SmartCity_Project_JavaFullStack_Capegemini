package com.smartcity.smartcityproject.controller;

import com.smartcity.smartcityproject.service.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam(name = "city", required = false) String city, Model model) {
        if (city == null || city.isEmpty()) {
            model.addAttribute("error", "City is required");
            return "weather"; 
        }

        JsonNode weatherData = weatherService.getWeatherForCity(city);

        if (weatherData != null) {
            model.addAttribute("weatherData", weatherData);
            model.addAttribute("city", city);
        } else {
            model.addAttribute("error", "Weather data not found for the city");
        }

        return "weather";
    }
}
