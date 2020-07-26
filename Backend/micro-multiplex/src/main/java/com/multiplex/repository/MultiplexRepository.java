package com.multiplex.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multiplex.model.MultiplexModel;

@Repository
public interface MultiplexRepository extends MongoRepository<MultiplexModel, String>{

	Optional<MultiplexModel> findByMultiplexNameAndLocation(String multiplexName, String location);

}
