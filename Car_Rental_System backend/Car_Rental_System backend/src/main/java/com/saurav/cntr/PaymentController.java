package com.saurav.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.saurav.model.Payment;

import com.saurav.service.PaymentService;


@RestController
@CrossOrigin("http://localhost:3000")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value = {"/payment/{id}"})
	public String paymentAdd(@RequestBody Payment payment,@PathVariable int id) {
		payment.setUserid(id);
		paymentService.add(payment);
		return "success";
	}
	
	@DeleteMapping(value = {"/payment/{id}"})
	public String paymentDelete(@PathVariable int id) {
		paymentService.removeByid(id);
		return "success";
	}
	
	@GetMapping(value = {"/payment/{id}"})
	public Payment paymentGet(@PathVariable int id) {
		return paymentService.getById(id);
	}
	
	@GetMapping(value = {"/payment"})
	public List<Payment> bookingList(){
		return paymentService.getAll();
	}
}
