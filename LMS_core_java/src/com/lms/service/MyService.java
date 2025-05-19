package com.lms.service;

public class MyService {

	public double computePercent(double totalMarks, double marksSecured) {
		/*
		 * Validate the inputs given as parameter to this methods
		 * */
		if(marksSecured > totalMarks)
			throw new RuntimeException("Marks Scored cannot be more than total marks");
		
		if(marksSecured < 0)
			throw new RuntimeException("Marks scored cannot be negative"); 
		
		/* Functional Code */
		double percent = (marksSecured * 100) / totalMarks ; 
		return percent; 
	}
	
	public String computeGrade(double percent) {
		/* Validate percent  */
		if(percent > 100)
			throw new RuntimeException("Percent cannot be more than 100");

		/* Functional logic: grade calculation */
		if(percent > 75)
			return "A"; 
		
		if(percent > 60)
			return "B"; 
		
		return "C"; 
		
	}
}
