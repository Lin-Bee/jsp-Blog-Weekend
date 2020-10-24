package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.User;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	public static UserDao getIntance() {
		return instance;
	}
	
	private UserDao() {}
	
	public User 로그인(User user) {
		//패스워드 세션에 저장하면 불법임 패스워드는 저장하지 않는다
		String sql="SELECT id,username,email,address FROM users WHERE username = ? AND password=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				User userEntity = User.builder()
					.id(rs.getInt("id"))
					.username(rs.getString("username"))
					.email(rs.getString("email"))
					.address(rs.getString("address"))
					.build();
				
				return userEntity;
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int 회원가입(User user) {
		String sql="INSERT INTO users(username, password, email, address, createDate) VALUES(?,?,?,?,now())";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int 회원수정(User user) {
		String sql="UPDATE users SET password = ?, email = ?, address = ? , createDate = now()  where id = ?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getAddress());
			pstmt.setInt(4, user.getId());
			pstmt.executeUpdate();
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
