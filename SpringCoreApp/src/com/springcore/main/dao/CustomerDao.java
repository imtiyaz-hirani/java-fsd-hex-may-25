package com.springcore.main.dao;

import com.springcore.main.model.Customer;

public class CustomerDao {

	public Customer getCustomer() {
	    return new Customer(1,"john doe","mumbai");
	}

}
