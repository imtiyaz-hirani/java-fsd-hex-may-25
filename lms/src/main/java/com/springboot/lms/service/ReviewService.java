package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.lms.exception.ResourceNotFoundException;

import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.model.Review;

import com.springboot.lms.repository.LearnerCourseRepository;

import com.springboot.lms.repository.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository reviewRepository;
	private LearnerCourseRepository learnerCourseRepository;

	public ReviewService(ReviewRepository reviewRepository, LearnerCourseRepository learnerCourseRepository) {
		super();
		this.reviewRepository = reviewRepository;
		this.learnerCourseRepository = learnerCourseRepository;
	}

	public Review postReview(int learnerId, int courseId, Review review) {
		// Fetch LearnerCourse from learnerId and courseId using JPQL , Native SQL

		// LearnerCourse learnerCourse =
		// learnerCourseRepository.getUsingNativeSql(learnerId,courseId)
		// .orElseThrow(()->new ResourceNotFoundException("Learner not enrolled in
		// course"));
		LearnerCourse learnerCourse = learnerCourseRepository.getUsingJPQL(learnerId, courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Learner not enrolled in course"));

		// Attach LearnerCourse to review
		review.setLearnerCourse(learnerCourse);

		// Add review in DB
		return reviewRepository.save(review);
	}

	public List<Review> getReviewByRating(String rating) {
		return reviewRepository.getByRating(rating);
	}

}
