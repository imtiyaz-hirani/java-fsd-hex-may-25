package com.springboot.lms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.lms.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * Whenever a RuntimeException is thrown in Controller, this method gets called
	 * */
	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<?> handleRuntime(RuntimeException e) {
		Map<String,String> map = new HashMap<>();
		map.put("msg", e.getMessage());
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(map);
	}
	
	/*
	 * Whenever a Custom ResourseNotFoundException is thrown in Controller, 
	 * this method gets called
	 * */
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		Map<String,String> map = new HashMap<>();
		map.put("msg", e.getMessage());
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(map);
	}
}
