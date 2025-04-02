package com.smartcity.smartcityproject.service;

import com.smartcity.smartcityproject.model.CityInfrastructure;
import com.smartcity.smartcityproject.repository.CityInfrastructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityInfrastructureService {

    @Autowired
    private CityInfrastructureRepository cityInfrastructureRepository;

    
    public List<CityInfrastructure> getAllInfrastructure() {
        return cityInfrastructureRepository.findAll();
    }

    
    public void addInfrastructure(CityInfrastructure infrastructure) {
        cityInfrastructureRepository.save(infrastructure);
    }
}
