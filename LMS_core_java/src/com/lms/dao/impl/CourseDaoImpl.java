package com.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lms.dao.CourseDao;
import com.lms.model.Course;
import com.lms.utility.DBUtility;

public class CourseDaoImpl implements CourseDao{
	DBUtility db = new DBUtility();
	
	@Override
	public void insert(Course course,int trackId) {
		Connection con = db.connect();
		String sql = "insert into course values (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course.getId());
			pstmt.setString(2, course.getTitle());
			pstmt.setDouble(3, course.getFee());
			pstmt.setDouble(4, course.getDiscount());
			pstmt.setString(5, course.getPublishDate().toString());
			pstmt.setInt(6, trackId);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		db.close();
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getByTrackId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
