package com.movie.multiplex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.multiplex.model.User;
import com.movie.multiplex.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}

	public User fetchUserByEmailIdAndPassword(String tempEmailId, String tempPassword) {
		return repo.findByEmailIdAndPassword(tempEmailId, tempPassword);
	}

}
