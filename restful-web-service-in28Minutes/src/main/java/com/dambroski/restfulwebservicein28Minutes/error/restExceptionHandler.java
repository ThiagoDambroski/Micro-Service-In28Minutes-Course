package com.dambroski.restfulwebservicein28Minutes.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dambroski.restfulwebservicein28Minutes.user.User;

@ControllerAdvice
@ResponseStatus
public class restExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFound(UserNotFoundException exception, WebRequest request){
		ErrorMessage error = ErrorMessage.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	

}
