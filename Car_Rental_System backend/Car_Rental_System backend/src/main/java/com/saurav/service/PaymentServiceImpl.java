package com.saurav.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.saurav.dao.PaymentDao;
import com.saurav.model.Payment;



@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;
	@Override
	public void add(Payment payment) {
		// TODO Auto-generated method stub
		paymentDao.save(payment);
		
	}

	@Override
	public void removeByid(int id) {
		// TODO Auto-generated method stub
		paymentDao.deleteById(id);
		
	}

	@Override
	public Payment getById(int id) {
		// TODO Auto-generated method stub
		Optional<Payment> opt = paymentDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Payment> getAll() {
		// TODO Auto-generated method stub
		Iterable<Payment > itr = paymentDao.findAll();
		List<Payment > lst = new ArrayList<Payment >();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}



}
