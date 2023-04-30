package com.wassim.productcategory.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AlreadyExistsException extends RuntimeException{

    private String message;
    public AlreadyExistsException(){}
    public AlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }
}
