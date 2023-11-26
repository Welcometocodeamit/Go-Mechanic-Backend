package com.gomechanic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gomechanic.models.Car;
import com.gomechanic.repositories.CarRepository;
import com.gomechanic.responsewrappers.CarResponseWrapper;

@Service
public class CarService {
	
	@Autowired CarRepository carRepository;
	
	 CarResponseWrapper carResponseWrapper = new CarResponseWrapper();
	
//	Get all services
	public ResponseEntity<?> getAllCars() {
		List<Car> foundedCar=carRepository.findAll();
		if(foundedCar.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Cars found, please add in some in database");
		}else {
			carResponseWrapper.setMessage("Following Cars found");
			carResponseWrapper.setData(foundedCar);
			return new ResponseEntity<> (carResponseWrapper, HttpStatus.FOUND);
		}
	}
	
//Add a car
	public ResponseEntity<?> addCar(Car car){
		Car savedCar=carRepository.save(car);
		if(savedCar==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car has not been added, server error");
		}else {
			carResponseWrapper.setMessage("Following car added");
			carResponseWrapper.setData(savedCar);
			return new ResponseEntity<> (carResponseWrapper, HttpStatus.OK);
		}
	}
	
//	Delete a car
	public ResponseEntity<?> deleteCar(int id){
		carRepository.deleteById(id);
		carResponseWrapper.setMessage("Car deletes");
		carResponseWrapper.setData(null);
		return new ResponseEntity<> (carResponseWrapper, HttpStatus.OK);
	}
	
	
	

}
