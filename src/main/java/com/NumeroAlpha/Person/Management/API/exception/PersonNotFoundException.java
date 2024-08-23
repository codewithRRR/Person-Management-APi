package com.NumeroAlpha.Person.Management.API.exception;

public class PersonNotFoundException extends RuntimeException {

	String message="No data found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PersonNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
