package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;
import com.cos.blog.utils.Script;

public class UserJoinProcAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.회원가입 진행(insert)Model로 이동
				User user = User.builder()
					.username(request.getParameter("username"))
					.password(request.getParameter("password"))
					.email(request.getParameter("email"))
					.address(request.getParameter("address"))
					.build();
				
				UserDao userDao = UserDao.getIntance();
				int result =userDao.회원가입(user);
				
				if(result == 1){
					Script.href(response,"/", "회원가입이 완료되었습니다.");
				}else {
					Script.back(response,"회원가입에 실패하였습니다.");
				}
				
				//2.로그인페이지로 이동 redirect
				//response.sendRedirect("/user/loginForm.jsp");
		
	}
	
}
