package com.gomechanic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomechanic.models.ServiceOrganizer;
import java.util.List;


public interface ServiceOrganizerRepository extends JpaRepository<ServiceOrganizer, Integer> {
	
	List<ServiceOrganizer> findByCity(String city);

}
