package com.cos.blog.config.action.post;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Detail;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostDeleteProcAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PostDao 연결
		PostDao postDao = PostDao.getIntance();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) return;
		int id = Integer.parseInt(request.getParameter("id"));
		User user = (User)session.getAttribute("principal");
		
		Post post=postDao.글내용(id);
		if(user.getId() != post.getUserId()) return;
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		
		int result = postDao.삭제하기(id);
		
		if(result == 1) {
			pw.print("ok");
			
		}else {
			pw.print("fail");
		}

		pw.flush();
	}
	
}
