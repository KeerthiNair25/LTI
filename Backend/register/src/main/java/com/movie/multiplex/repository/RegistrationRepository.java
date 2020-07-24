package com.movie.multiplex.repository;

import org.springframework.stereotype.Repository;

import com.movie.multiplex.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface RegistrationRepository extends MongoRepository<User, Integer>{

	public User findByEmailId(String email);
	public User findByEmailIdAndPassword(String email, String password);

}
