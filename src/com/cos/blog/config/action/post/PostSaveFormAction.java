package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;
import com.cos.blog.utils.Script;

public class PostSaveFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Script.href(response,"/", "게시글이 작성되었습니다.");
		response.sendRedirect("/post/saveForm.jsp");
		
	}
	
}
