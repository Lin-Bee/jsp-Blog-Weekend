package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostDao {
	
	private static PostDao instance = new PostDao();
	public static PostDao getIntance() {
		return instance;
	}
	
	private PostDao() {}
	
	public int 글갯수(String keyword) {
		String sql="SELECT count(*) FROM post WHERE title like ? OR content like ?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//순번으로 찾을 수 있음
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 글갯수() {
		String sql="SELECT count(*) FROM post";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//순번으로 찾을 수 있음
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 수정하기(Post post) {
		String sql="UPDATE post SET title=?, content=? WHERE id=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getId());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 삭제하기(int id) {
		String sql="DELETE FROM post WHERE id=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 조회수증가(int id) {
		String sql="UPDATE post Set readCount = readCount+1 WHERE id=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Post> 글목록(int page,String keyword) {
		List<Post> posts = new ArrayList<>();
			//0번째 부터 5개까지
		String sql = "SELECT *FROM post WHERE title like ? or content like ? ORDER BY id DESC limit ?,3";
		//DESC 역순으로 불러온다 ASC 작성순으로 불러온다
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setInt(3, page*3);
			ResultSet rs=pstmt.executeQuery();
			

			while (rs.next()) {
				Post post = Post.builder()
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.userId(rs.getInt("userId"))
						.build();
				posts.add(post);
			}
		return posts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
public List<Post> 글목록(int page) {
		List<Post> posts = new ArrayList<>();
			//0번째 부터 5개까지
		String sql = "SELECT *FROM post ORDER BY id DESC limit ?,3";
		//DESC 역순으로 불러온다 ASC 작성순으로 불러온다
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, page*3);
			ResultSet rs=pstmt.executeQuery();
			

			while (rs.next()) {
				Post post = Post.builder()
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.userId(rs.getInt("userId"))
						.build();
				posts.add(post);
			}
		return posts;
		} catch (Exception e) {
			e.printStackTrace();//빨간 오류가 터짐 !!! 젠장!!!확인할 것
		}
		return null;
	}

	public int 글쓰기(Post post) {
		String sql="INSERT INTO post(title, content, readCount,userId, createDate) VALUES(?,?,?,?,now())";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getReadCount());
			pstmt.setInt(4, post.getUserId());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
		
	public Post 글내용(int id) {
		String sql = "SELECT * FROM post WHERE id=? ";
		
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if (rs.next()) {
				Post post = Post.builder()
						
				.id(rs.getInt("id"))
				.title(rs.getString("title"))
				.content(rs.getString("content"))
				.readCount(rs.getInt("readCount"))
				.createDate(rs.getTimestamp("createDate"))
				.userId(rs.getInt("userId"))
				
				.build();
				
				return post;
			}					
		} catch (Exception e) {
			e.printStackTrace();
			}
		return null;
	}

	public int 글개수() {
		
		return 0;
	}
	
	
}
