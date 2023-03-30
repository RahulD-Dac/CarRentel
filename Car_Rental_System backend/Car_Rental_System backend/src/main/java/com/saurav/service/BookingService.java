package com.saurav.service;

import java.util.List;

import com.saurav.model.Booking;

public interface BookingService {
	void add(Booking booking);
	void removeByid(int id);
	Booking getById(int id);
	Booking getByEmail(String email);
	List<Booking> getAll();
}
