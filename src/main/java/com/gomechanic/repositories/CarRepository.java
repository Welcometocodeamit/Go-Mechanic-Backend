package com.gomechanic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomechanic.models.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
