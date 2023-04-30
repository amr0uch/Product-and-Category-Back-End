package com.wassim.productcategory.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	  public ResponseEntity<ResponseException> resourceNotFoundException(ResourceNotFoundException ex) {
	    HttpStatus badRequest = HttpStatus.NOT_FOUND;
		ResponseException message = new ResponseException(
				HttpStatus.NOT_FOUND.value(),
				ZonedDateTime.now(ZoneId.of("Z")),
				ex.getMessage(),
				badRequest
		);
	    
	    return new ResponseEntity<ResponseException>(message, badRequest);
	  }

	@ExceptionHandler(value = {AlreadyExistsException.class})
	public ResponseEntity<Object> AlreadyExistsException(AlreadyExistsException ex) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ResponseException message = new ResponseException(
				HttpStatus.BAD_REQUEST.value(),
				ZonedDateTime.now(ZoneId.of("Z")),
				ex.getMessage(),
				badRequest
		);
		return new ResponseEntity<>(message, badRequest);
	}





}
