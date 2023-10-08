package com.gomechanic.models;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;

@Entity
@Data
public class ServiceOrganizer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	@Size(min = 5, message = "Organization name should be 5 minimum of 5 characters")
	private String organizationName;
	
	@Column(nullable = false)
	@Size(min = 3, message = "City name should be min 3 characters")
	private String city;
	
	@Column(nullable = false)
	@Size(min = 3, message = "Service name should be min 3 characters")
	private String serviceName;
	
	@Column(nullable = false)
	private double serviceCost;
//	
//	@ManyToMany
//	private CarService carService;

}