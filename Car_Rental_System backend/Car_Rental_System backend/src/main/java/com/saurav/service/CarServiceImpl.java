package com.saurav.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.dao.CarDao;
import com.saurav.model.Car;




@Service
public class CarServiceImpl implements CarServices {
	
	@Autowired
	private CarDao carDao;
	@Override
	public void add(Car car) {
		// TODO Auto-generated method stub
		carDao.save(car);
		
	}

	public void modify(Car car) {
		// TODO Auto-generated method stub
		carDao.save(car);
		
	}
	
	@Override
	public void removeByid(int id) {
		// TODO Auto-generated method stub
		carDao.deleteById(id);
		
	}

	@Override
	public Car getById(int id) {
		// TODO Auto-generated method stub
		Optional<Car> opt = carDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		Iterable<Car> itr = carDao.findAll();
		List<Car> lst = new ArrayList<Car>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}

	@Override
	public List<Car> getAllByLocation(String Location) {
		// TODO Auto-generated method stub
		return carDao.findByLocation(Location);
	}

}
