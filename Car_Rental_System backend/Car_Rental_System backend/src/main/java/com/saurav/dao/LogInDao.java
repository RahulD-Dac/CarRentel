package com.saurav.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saurav.model.LogIn;
@Repository
public interface LogInDao extends JpaRepository<LogIn, Integer>{
	public LogIn findByUsername(@Param(value = "username")String username);
}
