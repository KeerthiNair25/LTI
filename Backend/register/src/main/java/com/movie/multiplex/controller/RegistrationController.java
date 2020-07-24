package com.movie.multiplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.multiplex.model.User;
import com.movie.multiplex.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registerUser")
	@CrossOrigin( origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			User userObj = service.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				throw new Exception("user with email id "+ tempEmailId + " is already present");
			}
		}
		
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin( origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		
		if(tempEmailId != null && tempPassword != null)
		{
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		
		if(userObj == null) {
			throw new Exception("Invalid Credentials!!");
		}
		return userObj;
	}

}
