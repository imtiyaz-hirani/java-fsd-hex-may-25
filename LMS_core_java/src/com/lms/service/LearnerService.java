package com.lms.service;

import java.util.List;

import com.lms.dao.LearnerDao;
import com.lms.dao.LearnerDaoImpl;
import com.lms.exception.InvalidIdException;
import com.lms.model.Learner;

public class LearnerService {
	
	LearnerDao dao = new LearnerDaoImpl(); //Polymorphic object. 
	
	public List<Learner> getAllLearners() {
		
		return dao.getAll();
	}

	public Learner getById(int id) throws InvalidIdException {
		 
		return dao.getById(id);
	}

}
