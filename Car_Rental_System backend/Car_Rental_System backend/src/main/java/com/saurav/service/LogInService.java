package com.saurav.service;

import java.util.List;

import com.saurav.model.LogIn;


public interface LogInService {
void add(LogIn login);
List<LogIn>getAll();
LogIn getByUsername(String username);
}
