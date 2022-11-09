package com.prateek.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.prateek.exception.StudentException;
import com.prateek.exception.MyErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> StudentExceptionHandler(StudentException se, WebRequest wr){
		
		MyErrorDetails mer = new MyErrorDetails(LocalDateTime.now(), se.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.BAD_REQUEST);
		
	}
	
}
