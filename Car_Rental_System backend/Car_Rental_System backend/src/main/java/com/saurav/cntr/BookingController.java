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

import com.saurav.model.Booking;
import com.saurav.service.BookingService;


@RestController
@CrossOrigin("http://localhost:3000")
public class BookingController {

	@Autowired
	private BookingService bookService;
	
	@PostMapping(value = {"/booking"})
	public String bookingtAdd(@RequestBody Booking booking) {
		bookService.add(booking);
		return "success";
	}
	
	@DeleteMapping(value = {"/booking/{id}"})
	public String bookingDelete(@PathVariable int id) {
		bookService.removeByid(id);
		return "success";
	}
	
	@GetMapping(value = {"/booking/{id}"})
	public Booking bookingGet(@PathVariable int id) {
		return bookService.getById(id);
	}
	
	@GetMapping(value = {"/booking"})
	public List<Booking> bookingList(){
		return bookService.getAll();
	}
	
	@GetMapping(value = {"/booking/byemail/{email}"})
	public Booking productListByEmail(@PathVariable String email){
		return bookService.getByEmail(email);
	}
}
