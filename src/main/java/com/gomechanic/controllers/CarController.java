package com.gomechanic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomechanic.models.Car;
import com.gomechanic.services.CarService;



@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*")
public class CarController {
	
	@Autowired CarService carService;
	
//	get all car
	@GetMapping("")
	public ResponseEntity<?> getAllCars(){
		return carService.getAllCars();
	}
	
//	Add a car
	@PostMapping("")
	public ResponseEntity<?> addCar(@RequestBody Car car){
		return carService.addCar(car);
	}
	
//	Delete a car
	@DeleteMapping("/deletecar/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id){
		return carService.deleteCar(id);
	}
	

}
