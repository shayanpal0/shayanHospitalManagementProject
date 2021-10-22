package com.plasmit.appointment.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnauthorizedException extends RuntimeException{

	public UnauthorizedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
