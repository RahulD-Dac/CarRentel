package com.saurav.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.dao.BookingDao;
import com.saurav.model.Booking;



@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	@Override
	public void add(Booking booking) {
		// TODO Auto-generated method stub
		bookingDao.save(booking);
		
	}

	@Override
	public void removeByid(int id) {
		// TODO Auto-generated method stub
		bookingDao.deleteById(id);
		
	}

	@Override
	public Booking getById(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> opt = bookingDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		Iterable<Booking> itr = bookingDao.findAll();
		List<Booking> lst = new ArrayList<Booking>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}

	@Override
	public Booking getByEmail(String email) {
		// TODO Auto-generated method stub
		return (Booking) bookingDao.findByEmail(email);
	}

}
