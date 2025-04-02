package com.smartcity.smartcityproject.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;
    private String description;
    private String advantages;
    
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Citizen> citizens = new ArrayList<>();

    public Service() {
        this.citizens = new ArrayList<>();
    }

    public Service(String name, String description, String advantages) {
        this.name = name;
        this.description = description;
        this.advantages = advantages;
        this.citizens = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public void addCitizen(Citizen citizen) {
        this.citizens.add(citizen);
    }
}
