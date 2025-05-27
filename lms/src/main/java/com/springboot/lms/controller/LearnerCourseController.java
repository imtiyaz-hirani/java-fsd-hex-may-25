package com.springboot.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.service.LearnerCourseService;

@RestController
public class LearnerCourseController {

	@Autowired
	private LearnerCourseService learnerCourseService;
	
	/*
	 * AIM: Enroll learner to course by adding record in relation entity
	 * PATH: /api/learner/enroll/course/{learnerId}/{courseId}
	 * METHOD: POST 
	 * PARAM: Path variable(learnerId,courseId) , Request Body ({ couponCode: ""})
	 * Response: LearnerCourse 
	 * 
	 * */
	@PostMapping("/api/learner/enroll/course/{learnerId}/{courseId}")
	public LearnerCourse enrollLearnerInCourse(@PathVariable int learnerId, 
									  @PathVariable int courseId, 
									  @RequestBody LearnerCourse learnerCourse) {
		return learnerCourseService.enrollLearnerInCourse(learnerId,courseId,learnerCourse);
	}
}
