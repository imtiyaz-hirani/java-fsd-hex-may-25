package com.springcore.main.service;

import com.springcore.main.dao.CustomerDao;
import com.springcore.main.model.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();
	public Customer getCustomer() {
		 
		return customerDao.getCustomer();
	}

}
