package com.multiplex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiplexDto {
	
	private String multiplexId;
	private String multiplexName;
	private String location;
	private int numberOfScreens;
}
