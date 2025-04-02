package com.smartcity.smartcityproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CityInfrastructure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    public CityInfrastructure(Long id, String name, String type, String description, String location) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.location = location;
	}
    public CityInfrastructure() {
    	
    }
	@Override
	public String toString() {
		return "CityInfrastructure [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", location=" + location + "]";
	}
	private String name;
    private String type;  
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	private String description;
    private String location;
}
