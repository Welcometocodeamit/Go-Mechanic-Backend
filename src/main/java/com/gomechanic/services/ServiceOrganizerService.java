package com.gomechanic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

}
