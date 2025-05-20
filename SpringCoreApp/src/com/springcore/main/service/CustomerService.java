package com.springcore.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.main.dao.CustomerDao;
import com.springcore.main.model.Customer;

@Service //<-- This registers this class CustomerService with Spring context
public class CustomerService {
	@Autowired   
	CustomerDao customerDao;
	
	
	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public Customer getCustomer() {
		 
		return customerDao.getCustomer();
	}

	public void createTable() {
		customerDao.createCustomerTable();
		
	}

	public void insertCustomer(String name, String city) {
		customerDao.insertCustomer(name,city);
		
	}

}
