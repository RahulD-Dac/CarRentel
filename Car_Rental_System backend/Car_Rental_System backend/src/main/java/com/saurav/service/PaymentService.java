package com.saurav.service;

import java.util.List;

import com.saurav.model.Payment;

public interface PaymentService {
	void add(Payment payment);
	void removeByid(int id);
	Payment getById(int id);
	List<Payment> getAll();
}
