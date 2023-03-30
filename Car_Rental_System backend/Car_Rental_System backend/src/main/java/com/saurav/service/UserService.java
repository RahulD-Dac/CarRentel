package com.saurav.service;

import java.util.List;

import com.saurav.model.LogIn;
import com.saurav.model.User;



public interface UserService {
	void add(User user);
	void removeByid(int id);
	User getById(int id);
	boolean existsByid(int id);
	List<User> getAll();
	User getByEmail(String email);
}
