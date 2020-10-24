package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.cos.blog.config.action.Action;
import com.cos.blog.utils.Script;

public class UserLogoutProcAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		Script.back(response, "로그아웃되었습니다.");
		//response.sendRedirect("/index.jsp");
		
	}

}
