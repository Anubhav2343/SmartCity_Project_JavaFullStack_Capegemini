package com.smartcity.smartcityproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityproject.model.Citizen;
import com.smartcity.smartcityproject.repository.CitizenRepository;

@Service
public class CitizenService {
	@Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }
}
