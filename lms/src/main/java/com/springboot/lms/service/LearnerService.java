package com.springboot.lms.service;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.Learner;
import com.springboot.lms.repository.LearnerRepository;
@Service
public class LearnerService {

	private LearnerRepository learnerRepository;

	public LearnerService(LearnerRepository learnerRepository) {
		this.learnerRepository = learnerRepository;
	}

	public Learner insertLearner(Learner learner) { 
		return learnerRepository.save(learner);
	}

}
