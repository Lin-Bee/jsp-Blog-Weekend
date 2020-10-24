package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;
import com.cos.blog.utils.Script;

public class UserUpdateProcAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("principal")==null) {
			return;
		} //서버에서 막아줘야하는것
		//1. SESION이 없으면 튕겨라
		
//		if(request.getParameter("id")==null || request.getParameter("id").equals("")) {
//			return; 
//		}
//		모든 페이지의 action마다 필요함 4개가오든 10개가 오든 100개가 오든 내가 지정한 값 맞는값일때만 확인 및 사용 가능하도록
//	    서버에서 막아줘야하는것
// 	2.공백 null 확인
		
//		3.데이터 검증() 숫자엔 숫자가 맞는지 이메일엔 이메일이 맞는지 등등
//	 	ex) 숫자가 맞는지 아닌지 검증하기 위해서 구글에서 java숫자 검증 치면 ㅇ0ㅇ 나온다.  세상 개발자들은 뭘하는건가 다 찾아서 긁었느ㅡㄴ 것만 같다.
//     네이버의 루시라는 라이브러리
		
		
		// 1.회원수정진행 진행(select)Model로 이동
		// 2.index페이지로 이동 redirect
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		System.out.println("id"+id);
		System.out.println("username"+username);
		System.out.println("password"+password);
		System.out.println("email"+email);
		System.out.println("address"+address);
		
		User user = User.builder()
				.id(id)
				.username(username)
				.password(password)
				.email(email)
				.address(address)
				
				.build();
		
		UserDao userDao = UserDao.getIntance();
		int result = userDao.회원수정(user);
		
		if(result ==1) {
			
			session.setAttribute("principal", user);
			Script.href(response,"/", "수정되었습니다.");
		}
		Script.back(response, "수정되었습니다.");
		//response.sendRedirect("index.jsp");
	}
}
