package com.gomechanic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class CarService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	@Size(min = 5, message = "Service name should be above 5 characters")
	private String serviceName;
	
	@Column(nullable = false)
	@Size(min = 5, message = "Service category should be above 5 characters")
	private String serviceCategory;
	
	@Column(nullable = false)
	@Size(min = 5, message = "Service details should be above 5 characters")
	private String serviceDetails;
//	
//	@ManyToMany
//	private ServiceOrganizer organizer;
	
	
	

}
