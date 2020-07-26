package com.multiplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.multiplex.dto.MultiplexDetailsDto;
import com.multiplex.dto.MultiplexDto;
import com.multiplex.exception.DuplicateRecordException;
import com.multiplex.service.MultiplexServiceImp;

@Controller
public class MultiplexController {

	@Autowired
	public MultiplexServiceImp multiplexService;

	@PostMapping("/addMultiplex")
	public ResponseEntity<MultiplexDetailsDto> addMultiplex(@RequestBody MultiplexDto multiplexDto) {
		MultiplexDetailsDto newMultiplex = multiplexService.addMultiplexDetails(multiplexDto);
		if(newMultiplex != null)
			return new ResponseEntity<MultiplexDetailsDto>(newMultiplex, HttpStatus.OK);
		else
			throw new DuplicateRecordException("Movie already exists");
	}
	
	@PostMapping("/deleteMultiplex")
	public String removeMultiplex(@RequestBody MultiplexDto multiplexDto) {
		String multiplexName = multiplexService.deleteMultiplex(multiplexDto);
		if(multiplexName != null)
			return multiplexName + " deleted";
		else
			return "unable to delete " + multiplexName;
		
	}
}
