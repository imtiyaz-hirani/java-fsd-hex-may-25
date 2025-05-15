package com.lms.model;

import java.time.LocalDate;

public class Enroll {

	//inject learner 
	Learner learner; 
	//inject course
	Course course;
	private LocalDate dateOfEnroll; 
	private String couponUsed;
	private String feePaid;
	
	public Enroll() { }
	
	public Enroll(Learner learner, Course course, LocalDate dateOfEnroll, String couponUsed, String feePaid) {
		super();
		this.learner = learner;
		this.course = course;
		this.dateOfEnroll = dateOfEnroll;
		this.couponUsed = couponUsed;
		this.feePaid = feePaid;
	}

	public Learner getLearner() {
		return learner;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getDateOfEnroll() {
		return dateOfEnroll;
	}

	public void setDateOfEnroll(LocalDate dateOfEnroll) {
		this.dateOfEnroll = dateOfEnroll;
	}

	public String getCouponUsed() {
		return couponUsed;
	}

	public void setCouponUsed(String couponUsed) {
		this.couponUsed = couponUsed;
	}

	public String getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(String feePaid) {
		this.feePaid = feePaid;
	}

	@Override
	public String toString() {
		return "Enroll [learner=" + learner + ", course=" + course + ", dateOfEnroll=" + dateOfEnroll + ", couponUsed="
				+ couponUsed + ", feePaid=" + feePaid + "]";
	} 
	
	
}
