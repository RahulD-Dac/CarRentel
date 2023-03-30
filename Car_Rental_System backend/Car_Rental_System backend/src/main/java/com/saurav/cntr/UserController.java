package com.saurav.cntr;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.saurav.model.User;
import com.saurav.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value=("/userregister"))
	public String userAdd(@RequestBody User user) {
		userService.add(user);
		return "success";
	}
	
	@PostMapping(value= {"/user"})
	public Object userLogin(@RequestBody User user ) {
		
		String email = user.getEmail();
		String plainPassword=user.getPassword();
		
		if(loginCheck(email, plainPassword)!=null) {
			return loginCheck(email, plainPassword);
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
		
		//user table check for logged in email and password
			public User loginCheck(String email, String plainPassword ) {
				
				User user = userService.getByEmail(email);
				if (user != null) {
					String hashedPassword=user.getPassword();
					if(checkPass(plainPassword, hashedPassword)) {
						return user;
					}
				}
				return null;
			}
	
	@DeleteMapping(value = {"/user/{id}"})
	public String userDelete(@PathVariable int id) {
		userService.removeByid(id);
		return "success";
	}
	
	@GetMapping(value = {"/user/{id}"})
	public User userGet(@PathVariable int id) {
		return userService.getById(id);
	}
	
	@GetMapping(value = {"/user"})
	public List<User> userList(){
		return userService.getAll();
	}
	
	
	

}
