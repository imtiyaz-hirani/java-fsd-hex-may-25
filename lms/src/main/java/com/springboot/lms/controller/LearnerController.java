package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Learner;
import com.springboot.lms.service.LearnerService;

@RestController
public class LearnerController {

	@Autowired
	private LearnerService learnerService;
	/*
	 * PATH: http://localhost:8080/api/learner/add
	 * Response: Hello Rest API!!!
	 * */
	@PostMapping("/api/learner/add")
	public Learner insertLearner(@RequestBody Learner learner) {
		return  learnerService.insertLearner(learner); 
	}
	
	/*
	 * AIM: To fetch all learner records 
	 * PATH: /api/learner/get-all
	 * Method: GET
	 * Response: List<Learner>
	 * */
	@GetMapping("/api/learner/get-all")
	public List<Learner> getAll() {
		return learnerService.getAll();
	}
	
	/*
	 * AIM: To delete learner by id 
	 * PATH: /api/learner/delete
	 * METHOD: delete 
	 * response: void 
	 * Input: id - PathVariable 
	 * */
	@DeleteMapping("/api/learner/delete/{id}")
	public void deleteLearner(@PathVariable int id) {
		learnerService.deleteLearner(id);
	}
	
}
/* 
 * {
    "name":"Harry Potter",
    "contact" : "9866746558"
	}
	
	Jackson Dependency 
	
	Learner learner = new Learner(); 
	learner.setName(name)
	learner.setContact(contact)
 * 
 */