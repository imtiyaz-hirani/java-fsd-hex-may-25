package com.hibernate.main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hibernate.main.model.Learner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LearnerRepository {

	@PersistenceContext
	private EntityManager em; 
	
	public void insert(Learner learner) {
		em.persist(learner);
	}

	public List<Learner> getAll() {
		return em.createQuery("FROM Learner", Learner.class).getResultList();
	}

}
/*
 *    HQL: FROM Learner 
 *    
 *    DaoImpl <class>
 * 
 * 	  	
 * 	  Repository <class>  	
 * 
 */