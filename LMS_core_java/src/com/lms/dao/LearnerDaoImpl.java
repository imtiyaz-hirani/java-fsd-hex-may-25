package com.lms.dao;

import java.util.List;

import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Learner;
import com.lms.utility.LearnerUtility;

public class LearnerDaoImpl implements LearnerDao{

 	private LearnerUtility learnerUtility = new LearnerUtility(); //100X: []
	@Override
	public List<Learner> getAll() {
		 return learnerUtility.getSampleData(); //100X: [l1,l2,l3,l4]
	}

	@Override
	public Learner getById(int id) throws InvalidIdException {
		
		for(Learner learner : learnerUtility.getSampleData()) { //100X: [l1,l2,l3,l4]
			if(learner.getId() == id) 
					return learner; 
		}
		
		throw new InvalidIdException("Id given is Invalid");
		
		/*
		List<Learner> list =  learnerUtility.getSampleData();  //3
		list = list.stream()
				.filter(l-> l.getId() == id)
				.toList();
		if(list.isEmpty())
			throw new InvalidIdException("Id given is Invalid");
		
		return list.get(0);
		*/ 
	}

	@Override
	public void deleteById(int id) throws InvalidIdException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Learner update(int id, Learner learner) throws InvalidIdException, InvalidInputException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Learner learner) throws InvalidInputException {
		// TODO Auto-generated method stub
		
	}

	 public static void main(String[] args) {
		LearnerDaoImpl dao = new LearnerDaoImpl();
		System.out.println("------------------------------------");
		dao.getAll().stream()
					.forEach(l-> System.out.println(l));
		System.out.println("------------------------------------");
		try {
			int id =3; 
			System.out.println("ID given " + id);
			System.out.println(dao.getById(id)); //100X: [l1,l2,l3,l4]
			
			id =7; 
			System.out.println("ID given " + id);
			System.out.println(dao.getById(id));
		} catch (InvalidIdException e) {
			 System.out.println(e.getMessage());
		}
	}

}
