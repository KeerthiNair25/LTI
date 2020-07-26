package com.multiplex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.multiplex.dto.UserExceptionDto;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<UserExceptionDto> duplicateRecExceptioHandler(DuplicateRecordException ex) {
		UserExceptionDto userExceptionDto = new UserExceptionDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				System.currentTimeMillis());
		return new ResponseEntity<UserExceptionDto>(userExceptionDto, HttpStatus.BAD_REQUEST);
	}

}
