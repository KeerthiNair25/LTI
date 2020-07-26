package com.multiplex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Multiplex")
public class MultiplexModel {
	
	@Id
	private String multiplexId;
	private String multiplexName;
	private String location;
	private int numberOfScreens;
	//private String movieId;

}
