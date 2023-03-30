package com.saurav.service;

import java.util.List;


import com.saurav.model.Car;


public interface CarServices {
	void add(Car car);
	void modify(Car car);
	void removeByid(int id);
	Car getById(int id);
	List<Car> getAllByLocation(String Location);
	List<Car> getAll();
}
