package com.springcore.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public List<Customer> getAll() {
		
		return customerDao.getAll();
	}
	
	/*
	 * [{{"id" : 1},{"name": "john"},{"city": "mumbai"}},
		{{"id" : 1},{"name": "john"},{"city": "mumbai"}},
		{{"id" : 1},{"name": "john"},{"city": "mumbai"}} ]
	 * */
	
	//[{id=1, name=John Doe, city=chennai}, {id=2, name=Jane Doe, city=delhi}, {id=3, name=Keith Orielly, city=mumbai}]

	public List<Customer> getAllv2() {
		List<Map<String, Object>> list =  customerDao.getAllv2();
		List<Customer> listCustomer = new ArrayList<>();
	//	System.out.println(list);
		for(Map<String,Object> map : list) {
			//System.out.println(map);
			Customer c = new Customer();
			c.setId((int)map.get("id"));
			c.setName((String)map.get("name"));
			c.setCity((String)map.get("city"));
			listCustomer.add(c);
		}
		return listCustomer; 
	}

	public Customer getById(int id) {
		Map<String,Object> map =  customerDao.getById(id);
		Customer customer = new Customer( 
				(int)map.get("id") , 
				(String)map.get("name"),
				(String)map.get("city"));
		
		return customer;
	}

}
