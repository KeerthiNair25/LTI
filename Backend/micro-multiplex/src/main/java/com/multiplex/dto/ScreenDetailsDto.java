package com.multiplex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDetailsDto {

	private String screenId;
	private String screenNames;	
	private String multiplexId;
	private String movieId;
}
