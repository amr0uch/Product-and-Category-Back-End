package com.wassim.productcategory.exceptions;

import java.time.ZonedDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseException {
	  private int statusCode;
	  private ZonedDateTime timestamp;
	  private String message;
	  private HttpStatus httpStatus;


}
