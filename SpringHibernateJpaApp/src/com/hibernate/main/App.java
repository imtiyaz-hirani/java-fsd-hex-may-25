package com.hibernate.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernate.main.model.Course;
import com.hibernate.main.model.Learner;
import com.hibernate.main.service.CourseService;
import com.hibernate.main.service.LearnerService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LearnerService learnerService = context.getBean(LearnerService.class);
		CourseService courseService = context.getBean(CourseService.class); 
		
		Scanner sc = new Scanner (System.in);
		while(true) {
			System.out.println("*****************Learner Menu******************");
			System.out.println("1.ADD Learner");
			System.out.println("2.GetAll Learner");
			System.out.println("3.Get LearnerByID");
			System.out.println("4.Edit Learner");
			System.out.println("5.Delete Learner By ID");
			System.out.println("6. Fetch Course by ID");
			System.out.println("0. Exit");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			
			if(choice == 0) break; 
			
			switch(choice) {
			case 1:
				learnerService.insert("Harry potter", "harry@gmail.com", "45454545");
				System.out.println("Record Inserted...");
				break;
			case 2:
				List<Learner> list=learnerService.getAll();
				list.stream().forEach(l->System.out.println(l));
				break;
			case 3:
				System.out.println("Enter ID");
				try {
					Learner learner =  learnerService.getById(sc.nextInt());
					System.out.println(learner);
				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				//hint use persist method 
				break;
			case 5:
				System.out.println("Enter ID");
				try {
					learnerService.deleteLearner(sc.nextInt());
					System.out.println("Record Deleted");
				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("Enter ID");
				try {
					Course course = courseService.getById(sc.nextInt());
					 System.out.println(course);
				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}	
				break; 
			default:
				break; 
			}
			 
		}
		sc.close();
		context.close();
	}

}
