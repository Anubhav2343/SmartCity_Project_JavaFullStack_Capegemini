package com.smartcity.smartcityproject.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_KEY = "9c082f393bec357cb5b4eeb9fa10768c"; 
    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid=" + API_KEY + "&units=metric";

    public JsonNode getWeatherForCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(WEATHER_API_URL, JsonNode.class, city);
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
