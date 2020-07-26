package com.multiplex.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multiplex.model.ScreenModel;

@Repository
public interface ScreenRepository extends CrudRepository<ScreenModel, String>{
	
	List<ScreenModel> findByMultiplexId(String multiplexId);

}
