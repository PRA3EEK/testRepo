package com.prateek.exception;

public class StudentException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StudentException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
