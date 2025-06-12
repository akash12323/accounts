package com.micro.account.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.micro.account.dto.ErrorResponseDto;
import com.micro.account.exception.CustomerAlreadyExistsException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException e,
			WebRequest webRequest) {
		ErrorResponseDto error = new ErrorResponseDto(webRequest.getDescription(false),
				HttpStatus.BAD_REQUEST,
				e.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(error,HttpStatus.BAD_REQUEST);
	}
}
