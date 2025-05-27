package com.springboot.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.LearnerCourse;

public interface LearnerCourseRepository extends JpaRepository<LearnerCourse, Integer>{

}
