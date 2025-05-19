package com.lms.service;

import com.lms.dao.UserDao;
import com.lms.dao.impl.UserDaoImpl;
import com.lms.exception.UserNotFoundException;
import com.lms.model.User;

public class UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public User login(String username, String password) throws UserNotFoundException {
		Integer isCredentialsValid =  userDao.login(username, password);
		
		if(isCredentialsValid == 1) {
			//fetch complete User details with id and role 
			User user  =  userDao.getUserByUsername(username); 
			if(user == null) {
				throw new UserNotFoundException("Invalid Credentials");
			}
			return user; 
		}
		else {
			throw new UserNotFoundException("Invalid Credentials");
		}
		
	}

}
