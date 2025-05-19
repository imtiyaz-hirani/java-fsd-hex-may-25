package com.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.dao.UserDao;
import com.lms.enums.Role;
import com.lms.exception.UserNotFoundException;
import com.lms.model.User;
import com.lms.utility.DBUtility;

public class UserDaoImpl implements UserDao {
	
	DBUtility db = DBUtility.getInstance();
	
	@Override
	public Integer login(String username, String password) throws UserNotFoundException {
		Connection con =  db.connect(); 
		String sql="select * from user where username=? AND password = ?";
		
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rst =  pstmt.executeQuery();
			if(rst.next() == true)
				return 1; 
			 
		} catch (SQLException e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
		}
		db.close();
		return 0;  //invalid = 0 
	}

	@Override
	public void signUp(User user) {
	}

	@Override
	public User getUserByUsername(String username) {
		Connection con =  db.connect(); 
		String sql="select * from user where username=?";
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rst = pstmt.executeQuery(); 
			
			if(rst.next() == true) {
				User user  = new User(); 
				user.setId(rst.getInt("id"));
				user.setUsername(username);
				user.setPassword(rst.getString("password"));
				user.setRole(Role.valueOf(rst.getString("role")));
				return user; 
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			 e.printStackTrace();
		}
		return null;
	}

}
