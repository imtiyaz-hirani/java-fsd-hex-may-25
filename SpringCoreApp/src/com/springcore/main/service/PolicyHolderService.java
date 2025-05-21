package com.springcore.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.main.dao.PolicyHolderDao;
import com.springcore.main.model.Address;
import com.springcore.main.model.PolicyHolder;

@Service
public class PolicyHolderService {
	
	PolicyHolderDao policyHolderDao; 
	
	@Autowired
	public PolicyHolderService(PolicyHolderDao policyHolderDao) {
		super();
		this.policyHolderDao = policyHolderDao;
	}


	public void insert(PolicyHolder policyHolder, Address address) {
		//right now, address is without key 
		//generate id for address randomly 
		int id = (int) (Math.random() * 10000000);
		address.setId(id);
		policyHolderDao.insertAddress(address); 
		
		//attach address to policyholder
		policyHolder.setAddress(address);
		
		//save policyholder in DB 
		policyHolderDao.insert(policyHolder);
	}


	public List<PolicyHolder> getAllWithAddres() {
		return policyHolderDao.getAllWithAddres();
		 
	}

}
