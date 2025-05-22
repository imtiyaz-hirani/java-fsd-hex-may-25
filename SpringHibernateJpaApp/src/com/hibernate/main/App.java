package com.hibernate.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernate.main.service.LearnerService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		LearnerService learnerService = context.getBean(LearnerService.class);
		learnerService.insert("Harry potter", "harry@gmail.com", "45454545");

		System.out.println("Record Inserted...");
		context.close();
	}

}
