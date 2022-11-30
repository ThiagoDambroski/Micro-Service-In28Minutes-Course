package com.dambroski.restfulwebservicein28Minutes.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class restExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handlerException(Exception exception,WebRequest request){
		ErrorMessage error = ErrorMessage.builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message(exception.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFound(UserNotFoundException exception, WebRequest request){
		ErrorMessage error = ErrorMessage.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorMessage error = ErrorMessage.builder().status(HttpStatus.BAD_REQUEST)
				.message("Total Erros: " + ex.getErrorCount() + " Frist error:" + ex.getFieldError().getDefaultMessage()
						).build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

}
