package com.lms.controller;

import java.util.List;
import java.util.Scanner;

import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.exception.UserNotFoundException;
import com.lms.model.Course;
import com.lms.model.Learner;
import com.lms.model.Track;
import com.lms.model.User;
import com.lms.service.CourseService;
import com.lms.service.EnrollService;
import com.lms.service.LearnerService;
import com.lms.service.UserService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LearnerService learnerService = new LearnerService();
		CourseService courseService = new CourseService();
		EnrollService enrollService = new EnrollService();
		UserService userService = new UserService();
		Learner learner = new Learner(); //learner object 
		Track track = new Track(); 
		Course course = new Course(); 
		User user = new User();
		
		while(true) {
			System.out.println("***********AUTH*****************");
			System.out.println("1. Login");
			System.out.println("2. SignUp");
			System.out.println("0. To Exit");
			System.out.println("*********************************");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting... Thank you");
				break; //while loop breaks 
			}
			switch(input) {
				case 1:
					System.out.println("****************LOGIN******************");
					System.out.println("Enter Username");
					String username = sc.next();
					System.out.println("Enter Password");
					String password = sc.next();
					try {
						user =  userService.login(username,password);
						System.out.println("Welcome " + username + " , " +  "You have logged I!!!!");
					} catch (UserNotFoundException e) {
						System.out.println(e.getMessage());
						break; 
					}
					
					System.out.println("****************************************");
					break;
				case 2: 
					break;
				default:
					System.out.println("Invaid Input!!!");
					continue; 
			}	
			if(user!= null) {
				if(user.getRole().toString().equals("LEARNER")) {
					System.out.println("********************MAIN LMS MENU****************");
					System.out.println("1. Add Learner");
					System.out.println("2. View All Learner");
					System.out.println("3. Delete Learner");
					System.out.println("4. Edit Learner");
					System.out.println("5. get Learner Info by ID");
					System.out.println("6. Add Track");
					System.out.println("7. Add Course");
					System.out.println("8. Get All Courses");
					System.out.println("9. Get Courses by Track");
					System.out.println("10. Enroll Learner to Course");
					System.out.println("0. To Exit");
					System.out.println("********************-------------****************");
				}
				else {
					System.out.println("here Instructor menu will go");
				}
			}
			
			input  = sc.nextInt(); 
			if(input == 0) {
				System.out.println("Exiting... Thank you");
				break; //while loop breaks 
			}
				
			switch(input) {
				case 1: //insert 
					System.out.println("Enter the name");
					sc.nextLine(); //hold the console
					learner.setName(sc.nextLine());
					System.out.println("Enter the email");
					learner.setEmail(sc.nextLine());
					try {
						learnerService.insert(learner);
						System.out.println("Record Inserted in DB...");
					} catch (InvalidInputException e) {
						System.out.println(e.getMessage());
					} 
					break;  
					
				case 2: 
					List<Learner> list =  learnerService.getAllLearners();
					list.stream().forEach(l-> System.out.println(l));
					break;
				
				case 3: 
					System.out.println("Enter Learner ID: ");
				try {
					learnerService.deleteById(sc.nextInt());
					System.out.println("learner deleted..");
				} catch (InvalidIdException e) {
					System.out.println(e.getMessage());
				}
					break;
				case 4: 
					System.out.println("Enter Learner ID: ");
				
					try {
						learner = learnerService.getById(sc.nextInt());
						System.out.println("Existing Record");
						System.out.println(learner);
						System.out.println("Enter Name");
						sc.nextLine(); //hold the console
						String name = sc.nextLine(); //type
						System.out.println("Enter email");
						String email = sc.nextLine();
						learnerService.update(learner, name,email); 
						System.out.println("Learner record updated..");
					} catch (InvalidIdException | InvalidInputException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("Record Update...");
					break;
				case 5: 
					System.out.println("Enter Learner ID: ");
						try {
							learner =  learnerService.getById(sc.nextInt());
							System.out.println(learner);
						} catch (InvalidIdException e) {
							System.out.println(e.getMessage());
						}
					break;
				case 6: //adding track 
					System.out.println("Enter track name");
					sc.nextLine(); 
					track.setName(sc.nextLine());
					courseService.insertTrack(track); 
					System.out.println("Track added in DB");
					break; 
				case 7: //adding course
					System.out.println("Enter title");
					sc.nextLine();
					course.setTitle(sc.nextLine());
					System.out.println("Enter fee");
					course.setFee(sc.nextDouble());
					System.out.println("Enter discount");
					course.setDiscount(sc.nextDouble());
					System.out.println("Enter Track Id");
					int trackId = sc.nextInt();
					courseService.insertCourse(course,trackId);
					System.out.println("Course added in DB");
					break; 
				case 8: //get all courses
					 
					courseService.getAll()
							.stream()
							.forEach(c->{
								System.out.println(c.getId() + "\t" 
										+ c.getTitle() + "\t"
										+ c.getFee() + "\t" 
										+ c.getTrack().getName());	
							});
					break;
				case 9: //get courses by track 
					
					break; 
				case 10:
					System.out.println("Enter Learner ID: ");
					int learnerID = sc.nextInt();
					System.out.println("Enter Course ID:");
					int courseId = sc.nextInt();
					
					try {
						enrollService.enroll(learnerID,courseId,sc);
						System.out.println("Learner Enrolled In Course");
					} catch (InvalidIdException e) {
						 System.out.println(e.getMessage());
					} catch(IllegalArgumentException e) {
						System.out.println("Coupon code is Invalid!!");
					}
					break; 
				default: 
					System.out.println("Invaid Input!!!");
			}	
		}
		
		sc.close();
	}
}
