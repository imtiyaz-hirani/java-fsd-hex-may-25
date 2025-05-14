package com.lms.controller;

import java.util.List;
import java.util.Scanner;

import com.lms.exception.InvalidIdException;
import com.lms.model.Learner;
import com.lms.service.LearnerService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LearnerService learnerService = new LearnerService();
		
		while(true) {
			System.out.println("********************MAIN LMS MENU****************");
			System.out.println("1. Add Learner");
			System.out.println("2. View All Learner");
			System.out.println("3. Delete Learner");
			System.out.println("4. Edit Learner");
			System.out.println("5. get Learner Info by ID");
			System.out.println("0. To Exit");
			System.out.println("********************-------------****************");
			int input  = sc.nextInt(); 
			if(input == 0) {
				System.out.println("Exiting... Thank you");
				break; //while loop breaks 
			}
				
			switch(input) {
				case 1: 
					break;  
				case 2: 
					List<Learner> list =  learnerService.getAllLearners();
					list.stream().forEach(l-> System.out.println(l));
					break;
				case 3: 
					break;
				case 4: 
					break;
				case 5: 
					System.out.println("Enter Learner ID: ");
						try {
							Learner learner  =  learnerService.getById(sc.nextInt());
							System.out.println(learner);
						} catch (InvalidIdException e) {
							System.out.println(e.getMessage());
						}
					break;
				default: 
					System.out.println("Invaid Input!!!");
			}	
		}
		
		sc.close();
	}
}
