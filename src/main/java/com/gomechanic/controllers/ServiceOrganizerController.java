package com.gomechanic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	Find by city
	@GetMapping("/services/{city}")
	public ResponseEntity<?> findByCity(@PathVariable String city){
		return organizerService.findByCity(city);
	}
	
//	delete by id
	@DeleteMapping("/services/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		return organizerService.deleteGarage(id);
	}
	
//	Update by id
	@PutMapping("/services/updategarage/{id}")
	public ResponseEntity<?> updateGarage(@PathVariable int id, @RequestBody ServiceOrganizer garage){
		return organizerService.updateGarage(id, garage);
	}
	
}