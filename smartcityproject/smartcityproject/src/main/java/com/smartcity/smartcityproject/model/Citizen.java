package com.smartcity.smartcityproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
	
    public Citizen(String name, Service service) {
        this.name = name;
        this.service = service;
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
	
	public Citizen(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	public Citizen(int id, String name, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String name;
    private String email;
    private String address;
}
