package com.oc.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public  ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ExceptionModel em = new ExceptionModel(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(em, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public  ResponseEntity<Object> handleAllException(UserNotFoundException ex, WebRequest request) {
		ExceptionModel em = new ExceptionModel(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(em, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionModel em = new ExceptionModel(new Date(),"Validation Failed",ex.getMessage());
		return new ResponseEntity<Object>(em, HttpStatus.BAD_REQUEST);
	}
}
