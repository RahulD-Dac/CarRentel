package com.saurav.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.saurav.model.Car;


import com.saurav.service.CarServices;


@RestController
@CrossOrigin("http://localhost:3000")
public class CarController {

	@Autowired
	private CarServices carService;
	
	@PostMapping(value = {"/car"})
	public String carAdd(@RequestBody Car car) {
		carService.add(car);
		return "success";
	}
	
	@PutMapping(value = {"/car/{id}"})
	public String carUpdate(@RequestBody Car car) {
		carService.modify(car);
		return "success";
	}
	
	@DeleteMapping(value = {"/car/{id}"})
	public String carDelete(@PathVariable int id) {
		carService.removeByid(id);
		return "success";
	}
	
	@GetMapping(value = {"/car/{id}"})
	public Car carGet(@PathVariable int id) {
		return carService.getById(id);
	}
	
	@GetMapping(value = {"/car"})
	public List<Car> carList(){
		return carService.getAll();
	}
	
	@GetMapping(value = {"/car/bylocation/{location}"})
	public List<Car> productListByName(@PathVariable String location){
		return carService.getAllByLocation(location);
	}
}
