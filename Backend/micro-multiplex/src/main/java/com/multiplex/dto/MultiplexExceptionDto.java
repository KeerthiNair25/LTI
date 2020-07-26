package com.multiplex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiplexExceptionDto {

	private String message;
	private Integer errorCode;
	private Long timeStamp;

}
