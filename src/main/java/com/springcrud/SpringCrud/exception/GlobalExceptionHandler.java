package com.springcrud.SpringCrud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(SomethingIsMissingException.class)
	public ResponseEntity<?> handleSpecificException(SomethingIsMissingException exception , WebRequest req)
	{
		ErrorData ED = new ErrorData(new Date(), exception.getMessage(), req.getDescription(false));
		return new ResponseEntity(ED,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<?> handlerGlobalException(Exception exception, WebRequest req){
		ErrorData ED = new ErrorData(new Date(), exception.getMessage(),req.getDescription(false));
		return new ResponseEntity(ED,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
		
}
 