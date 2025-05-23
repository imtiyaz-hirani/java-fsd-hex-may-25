package com.springcore.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	/*
	 * [{id=1, name=jack sparrow, panNo=AGEER3476K, address_id=7148221, street=kingston avenue, city=mumbai, state=MS}]

	 */
	public List<PolicyHolder> getAllWithAddresv2() {
		List<Map<String,Object>> list =  policyHolderDao.getAllWithAddresv2();
		List<PolicyHolder> listPh = new ArrayList<>();
		//System.out.println(list);
		for(Map<String,Object> map : list) {
			 Address address = new Address();
			 address.setStreet((String)map.get("street"));
			 address.setCity((String)map.get("city"));
			 address.setState((String)map.get("state")); 
			 
			 PolicyHolder ph = new PolicyHolder();
			 ph.setName((String)map.get("name"));
			 ph.setPanNo((String)map.get("panNo"));
			 
			 ph.setAddress(address);
			 listPh.add(ph);
		}
		return listPh;  
	}

}
