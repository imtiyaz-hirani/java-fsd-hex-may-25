package com.test;

 
 import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lms.service.MyService;

public class MyServiceTest {

	MyService myService; 
	
	@BeforeEach
	public void init() {
		myService = new MyService();
	}
	
	@Test
	public void computePercentTest() {
		
		//Use Case 1: valid values 
		
		/* preparing input */
		double totalMarks = 500; 
		double marksSecured = 435;
		
		/*Call Service method */
		double actualPercent =  myService.computePercent(totalMarks, marksSecured);
		double expectedPercent = 87; 
		
		Assertions.assertEquals(expectedPercent, actualPercent);
		
		//Use Case 2: invalid marksSecured - Exception thrown 
		
		/*Call Service method */
		RuntimeException e = assertThrows(
				RuntimeException.class, ()-> {
			myService.computePercent(500, 535);
		});
		assertEquals("marks Scored cannot be more than total marks".toLowerCase(), 
				e.getMessage().toLowerCase());
		
		 
		//Use Case 3: Failed Exception 
		assertDoesNotThrow(()-> {
			myService.computePercent(500, 435);
		} ,"");
		
		//Use Case 4: negative marks scored 
		e = assertThrows(
				RuntimeException.class, ()-> {
			myService.computePercent(500, -78);
		});
		assertEquals("Marks scored cannot be negative".toLowerCase(), 
				e.getMessage().toLowerCase());
	}
	
	
}
