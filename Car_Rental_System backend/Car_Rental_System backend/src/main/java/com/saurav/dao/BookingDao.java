package com.saurav.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saurav.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	public Booking findByEmail(@Param(value = "email") String email);

}
