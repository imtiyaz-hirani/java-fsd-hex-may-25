package com.hibernate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.main.model.Course;
import com.hibernate.main.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}


	public Course getById(int id) {
		 
		return courseRepository.getById(id);
	}

}
