package com.NumeroAlpha.Person.Management.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<String> handlerException(PersonNotFoundException exception) {
		logger.error("Exception Occured : ", exception);
		logger.info("This is an info message: ");
	
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
