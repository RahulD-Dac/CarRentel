package com.saurav.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.dao.LogInDao;
import com.saurav.model.LogIn;

@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private LogInDao logInDao;
	@Override
	public List<LogIn> getAll() {
		Iterable<LogIn> itr = logInDao.findAll();
		List<LogIn> lst = new ArrayList<LogIn>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}
	@Override
	public void add(LogIn login) {
		logInDao.save(login);
		
	}
	@Override
	public LogIn getByUsername(String username) {
		LogIn login=logInDao.findByUsername(username);
		return login;
	}

}
