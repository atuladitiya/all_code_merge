package com.example.demo.error;

public class EmployeeAlreadyExistsException extends Exception {
	
	public EmployeeAlreadyExistsException (String message) {
		super(message);
	}

}
