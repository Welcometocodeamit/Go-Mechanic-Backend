package com.gomechanic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gomechanic.models.Car;
import com.gomechanic.models.ServiceOrganizer;
import com.gomechanic.repositories.ServiceOrganizerRepository;
import com.gomechanic.responsewrappers.ServiceOrganizerResponseWrapper;

@Service
public class ServiceOrganizerService {
	
	@Autowired ServiceOrganizerRepository serviceOrganizerRepository;
	
    ServiceOrganizerResponseWrapper wrapper = new ServiceOrganizerResponseWrapper();
	
//	Get all services
	public ResponseEntity<?> getAllServices() {
		List<ServiceOrganizer> foundedService=serviceOrganizerRepository.findAll();
		if(foundedService.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No service found, please add in some in database");
		}else {
			wrapper.setMessage("Following services found");
			wrapper.setData(foundedService);
			return new ResponseEntity<> (wrapper, HttpStatus.FOUND);
		}
	}
	
//	Add service
	
	public ResponseEntity<?> addService(ServiceOrganizer serviceOrganizer){
		ServiceOrganizer savedService=serviceOrganizerRepository.save(serviceOrganizer);
		if(savedService==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Service has not been added, server error");
		}else {
			wrapper.setMessage("Following service added");
			wrapper.setData(savedService);
			return new ResponseEntity<> (wrapper, HttpStatus.OK);
		}
	}
	
//	find garage by city
	
	public ResponseEntity<?> findByCity(String city){
		List<ServiceOrganizer> foundGarage = serviceOrganizerRepository.findByCity(city);
		if(foundGarage.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No garage found with the same city, please add in some in database");
		}else {
			wrapper.setMessage("Following garages found");
			wrapper.setData(foundGarage);
			return new ResponseEntity<> (wrapper, HttpStatus.FOUND);	
		}
	}
	
//	find garage by id
	public ResponseEntity<?> getGarageById(int id){
		  ServiceOrganizer foundGarage=serviceOrganizerRepository.findById(id).orElseThrow(()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Garage with given id not found");
		});
			  wrapper.setData(foundGarage);
			  wrapper.setMessage("Following garage found");
			  return new ResponseEntity<>(wrapper, HttpStatus.FOUND);
	}
	
	
//	Delete garage by id 
	public ResponseEntity<?> deleteGarage(int id){
		serviceOrganizerRepository.deleteById(id);
		wrapper.setMessage("Garage deleted");
		wrapper.setData(null);
		return new ResponseEntity<> (wrapper, HttpStatus.OK);
	}
	
//	Update garage by id
	public ResponseEntity<?> updateGarage(int id, ServiceOrganizer garage){
		getGarageById(id);
		garage.setId(id);
		ServiceOrganizer updatedGarage=serviceOrganizerRepository.save(garage);
		wrapper.setData(updatedGarage);
		wrapper.setMessage("Garage updated");
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
		
	}
	

}
