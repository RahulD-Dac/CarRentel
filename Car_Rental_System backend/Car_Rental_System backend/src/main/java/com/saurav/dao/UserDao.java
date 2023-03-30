package com.saurav.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saurav.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	public User findByEmail(@Param(value = "email")String email);
}
