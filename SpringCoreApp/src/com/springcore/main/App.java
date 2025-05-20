package com.springcore.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.main.model.Customer;
import com.springcore.main.service.CustomerService;
import com.springcore.main.service.MyService;

public class App {
	public static void main(String[] args) {	
		/* Reaching out to my Configuration class */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService customerService = context.getBean(CustomerService.class); 
		 
//		System.out.println("1. Create table");
//		System.out.println("2. Insert Customer in the DB");
		
		/*Create Customer table */
		customerService.createTable();
		 System.out.println("Table created ");
		 
		 customerService.insertCustomer("John Doe", "chennai");
		 customerService.insertCustomer("Jane Doe", "delhi");
		 customerService.insertCustomer("Keith Orielly", "mumbai");

		 context.close();
	}
}
