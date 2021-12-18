package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9176193024160425413L;

	public UserNotFoundException(String message) {
		super(message);
	}

	
}
