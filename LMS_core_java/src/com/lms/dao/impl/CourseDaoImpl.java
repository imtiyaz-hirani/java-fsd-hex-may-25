package com.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.CourseDao;
import com.lms.model.Course;
import com.lms.model.Track;
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
		Connection con = db.connect();
		String sql="select * from course c join track t ON c.track_id = t.id";
		List<Course> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				Course course = new Course();
				course.setId(rst.getInt("id"));
				course.setTitle(rst.getString("title"));
				course.setFee(rst.getDouble("fee"));
				
				Track track = new Track();
				track.setName(rst.getString("name"));
				
				//attach track to course 
				course.setTrack(track);
				list.add(course);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		db.close();
		return list;
	}

	@Override
	public List<Course> getByTrackId() {
		// TODO Auto-generated method stub
		return null;
	}
}
