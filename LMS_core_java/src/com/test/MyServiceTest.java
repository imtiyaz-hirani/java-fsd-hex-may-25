package com.test;

 
 import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lms.enums.Role;
import com.lms.model.Learner;
import com.lms.model.User;
import com.lms.service.MyService;

public class MyServiceTest {

	MyService myService; 
	Learner l1; 
	Learner l2;
	Learner l3; 
	List<Learner> list; 
	
	@BeforeEach
	public void init() {
		myService = new MyService();
		l1 = new Learner(1,"test1", "test1@gmail.com", 
				new User(1,"test1@gmail.com","test1@123",Role.LEARNER));
		l2 = new Learner(2,"test2", "test2@gmail.com", 
				new User(2,"test2@gmail.com","test2@123",Role.LEARNER));
		l3 = new Learner(3,"test3", "test3@gmail.com", 
				new User(3,"test3@gmail.com","test3@123",Role.LEARNER));
		
		list = Arrays.asList(l1,l2,l3);
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
	
	@Test
	public void filterListByIdTest() {
		List<Learner> expectedList = Arrays.asList(l1,l3); 
		assertEquals(expectedList, myService.filterListById(list, 2));
		
		expectedList = Arrays.asList(l2,l3); 
		assertEquals(expectedList, myService.filterListById(list, 1));
		
		RuntimeException e = assertThrows(
				RuntimeException.class, ()-> {
			myService.filterListById(null, 1);
		});
		assertEquals("list cannot be null".toLowerCase(), 
				e.getMessage().toLowerCase());
		
		List<Learner> emptyList = Arrays.asList();
		e = assertThrows(
				RuntimeException.class, ()-> {
			myService.filterListById(emptyList, 1);
		});
		assertEquals("list cannot be empty".toLowerCase(), 
				e.getMessage().toLowerCase());
	}
	
}


















