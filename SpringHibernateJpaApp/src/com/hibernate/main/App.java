package com.hibernate.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernate.main.model.Learner;
import com.hibernate.main.service.LearnerService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		LearnerService learnerService = context.getBean(LearnerService.class);
		learnerService.insert("Ronald Weasley", "ronald@gmail.com", "66598656");

		//System.out.println("Record Inserted...");
		
		List<Learner> list =  learnerService.getAll();
		list.stream().forEach(System.out :: println);
		context.close();
	}

}
