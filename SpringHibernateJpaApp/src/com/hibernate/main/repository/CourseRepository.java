package com.hibernate.main.repository;

import org.springframework.stereotype.Repository;

import com.hibernate.main.model.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CourseRepository {

	@PersistenceContext
	private EntityManager em;

	public Course getById(int id) {
		 
		return em.find(Course.class, id);
	} 
	
	
}
