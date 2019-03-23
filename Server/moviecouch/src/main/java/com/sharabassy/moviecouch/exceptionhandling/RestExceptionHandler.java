package com.sharabassy.moviecouch.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class RestExceptionHandler 
{

	//Exception handler for NotFoundException
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(NotFoundException exc)
	{
		CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),
																  System.currentTimeMillis(),
																  exc.getMessage());


		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	//General exception handler for any exception (Catch All)
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exc)
	{
		CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(),
																  System.currentTimeMillis(),
																  exc.getMessage());
		
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
