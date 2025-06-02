package com.springboot.lms.service;

import com.springboot.lms.model.Course;
import com.springboot.lms.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }

    public Course postCourse(Course course) {
        return courseRepository.save(course);
    }

}
