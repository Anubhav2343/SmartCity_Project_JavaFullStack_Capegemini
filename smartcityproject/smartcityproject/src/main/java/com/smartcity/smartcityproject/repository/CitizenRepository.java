package com.smartcity.smartcityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.smartcityproject.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
	
}
