package com.lms.exception;

public class InvalidCouponExcpetion extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidCouponExcpetion(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 

}