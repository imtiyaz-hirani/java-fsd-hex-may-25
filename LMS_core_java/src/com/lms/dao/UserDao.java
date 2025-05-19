package com.lms.dao;

import com.lms.exception.UserNotFoundException;
import com.lms.model.User;

public interface UserDao {
	Integer login(String username,String password) throws UserNotFoundException;
	void signUp(User user);
	User getUserByUsername(String username);
}
