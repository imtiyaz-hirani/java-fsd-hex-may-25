package com.springboot.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
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