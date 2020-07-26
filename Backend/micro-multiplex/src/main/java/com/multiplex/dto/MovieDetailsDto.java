package com.multiplex.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailsDto 
{
	private String movieId;
	private String movieName;
	private String language;
	private String director;
	private String producer;
	private String cast;
	private double rating;
	private String genre;
	private List<MultiplexDetailsDto> allocatedMultiplexes;

}
