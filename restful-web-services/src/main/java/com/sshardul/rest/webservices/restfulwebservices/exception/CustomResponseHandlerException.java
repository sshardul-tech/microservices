package com.sshardul.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseHandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	 public final ResponseEntity<Object> handleUserBadRequestException(Exception ex, WebRequest request){
		
		CustomException customException = new CustomException(new Date(), null, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(customException,HttpStatus.BAD_REQUEST);
		 
	 }
	
	@ExceptionHandler(UserNotFound.class)
	 public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
		
		CustomException customException = new CustomException(new Date(), null, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(customException,HttpStatus.NOT_FOUND);
		 
	 }
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomException customException = new CustomException(new Date(), null, "size must be between 2 character", request.getDescription(false));
		
		return new ResponseEntity(customException,HttpStatus.BAD_REQUEST);
	}

}
