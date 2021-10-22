package com.plasmit.appointment.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
	extends ResponseEntityExceptionHandler{
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);
		/*@ExceptionHandler(Exception.class)
		public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
			return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		
		@ExceptionHandler(PatientNotFoundException.class)
		public final ResponseEntity<Object> handleUserNotFoundException(PatientNotFoundException ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(UnauthorizedException.class)
		protected ResponseEntity<Object> handleMethodArgumentNotValid(UnauthorizedException ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}	
		
		@ExceptionHandler(BusinessException.class)
		public final ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@Override
        protected ResponseEntity<Object> handleNoHandlerFoundException(
                NoHandlerFoundException ex, 
                HttpHeaders headers, 
                HttpStatus status, 
                WebRequest request) {

            List<String> details = new ArrayList<String>();
            details.add(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));
            ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"URL Not Found",
					request.getDescription(false));
            
            return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
            
        }


}
