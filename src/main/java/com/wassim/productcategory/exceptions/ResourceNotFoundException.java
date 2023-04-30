package com.wassim.productcategory.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
	private String message;
	public ResourceNotFoundException(){}
	public ResourceNotFoundException(String message)
	{
		    super(message);
			this.message = message;
	}
}
