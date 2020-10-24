package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserLoginFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인페이지로 이동
		response.sendRedirect("/user/loginForm.jsp");
		
	}
	
}
