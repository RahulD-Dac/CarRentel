package com.saurav.cntr;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurav.model.LogIn;

import com.saurav.service.LogInService;


@RestController
@CrossOrigin("http://localhost:3000")
public class LogInController {
 @Autowired
 private LogInService logInService;
 
 @PostMapping(value= {"/login"})
	public Object userLogin(@RequestBody LogIn login ) {
		
		String username = login.getUsername();
		String plainPassword=login.getPassword();
		
		if(loginCheck(username, plainPassword)!=null) {
			return loginCheck(username, plainPassword);
		}
		else
			return null;				
	}

 
//checking BCrypt password
		static private boolean checkPass(String plainPassword, String hashedPassword) {
			if (BCrypt.checkpw(plainPassword, hashedPassword)) {
				System.out.println("The password matches.");
				return true;
			}
			else {
				System.out.println("The password does not match.");
				return false;
			}
		}
		
		//login table check for logged in email and password
			public LogIn loginCheck(String username, String plainPassword ) {
				
				LogIn login = logInService.getByUsername(username);
				if (login != null) {
					String hashedPassword=login.getPassword();
					if(checkPass(plainPassword, hashedPassword)) {
						return login;
					}
				}
				return null;
			}

 
 @GetMapping( {"/login"})
	public List<LogIn> loginList(){
		return logInService.getAll();
	}
}
