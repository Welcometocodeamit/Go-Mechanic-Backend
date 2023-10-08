package com.gomechanic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomechanic.models.ServiceOrganizer;

public interface ServiceOrganizerRepository extends JpaRepository<ServiceOrganizer, Integer> {

}
