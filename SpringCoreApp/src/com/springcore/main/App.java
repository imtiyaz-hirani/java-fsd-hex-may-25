package com.springcore.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.main.model.Customer;
import com.springcore.main.service.CustomerService;

public class App {

	public static void main(String[] args) {
		
		/* Reaching out to my Configuration class */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerService customerService = new CustomerService();
		Customer customer =  customerService.getCustomer();
		System.out.println(customer);
		
		context.close();
	}

}
