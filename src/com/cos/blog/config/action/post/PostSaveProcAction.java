package com.cos.blog.config.action.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.utils.Script;
import com.mysql.cj.xdevapi.Result;

import lombok.Builder;

public class PostSaveProcAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) return;
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		String title = request.getParameter("title");
		title = title.replace("<","&lt;");
		title = title.replace(">","&rt;");
		String content = request.getParameter("content");
			
		//공백확인
		Post post = Post.builder()
				.title(title)
				.content(content)
				.readCount(0)
				.userId(userId)
				.build();
			
		//값 검증	
		PostDao postDao = PostDao.getIntance();
		int result = postDao.글쓰기(post);
		
		if(result == 1) {
			Script.href(response, "/", "글쓰기 성공");
		}else {
			Script.href(response, "/", "글쓰기 실패");
		}
		
		//list로 돌아가기
		//response.sendRedirect("/");
		
	}
	
}
