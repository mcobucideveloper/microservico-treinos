package com.example.demo.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = DefaultException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(DefaultException e) {
    	  	
        return new ResponseEntity<ErrorResponse>(e.getErrorResponse(), e.httpStatus);
    }
	
	
}
