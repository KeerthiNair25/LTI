package com.multiplex.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiplexDetailsDto {
	
	private String multiplexId;
	private String multiplexName;
	private String location;
	private int numberOfScreens;
	private List<String> screenNames;
	
}
