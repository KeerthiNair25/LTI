package com.multiplex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Screen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenModel {
	
	@Id
	private String screenId;
	private String screenName;
	private String multiplexId;	
	private String movieId;

}
