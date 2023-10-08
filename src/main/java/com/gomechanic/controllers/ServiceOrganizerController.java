package com.gomechanic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomechanic.models.ServiceOrganizer;
import com.gomechanic.services.ServiceOrganizerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ServiceOrganizerController {
	
	@Autowired ServiceOrganizerService organizerService;
	
	
//	Get all services
	@GetMapping("/services")
	public ResponseEntity<?> getAllServices(){
		return organizerService.getAllServices();
	}
	
//	Add service
	@PostMapping("/services")
	public ResponseEntity<?> addService(@RequestBody ServiceOrganizer serviceOrganizer){
		return organizerService.addService(serviceOrganizer);
	}
}