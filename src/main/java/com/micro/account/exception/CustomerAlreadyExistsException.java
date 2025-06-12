package com.micro.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = -6356389333856858945L;

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}
}
