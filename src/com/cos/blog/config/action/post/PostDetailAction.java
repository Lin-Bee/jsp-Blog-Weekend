package com.cos.blog.config.action.post;

import java.io.IOException;
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
import com.cos.blog.utils.Script;

public class PostDetailAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.값이 null 인지 아이디값 받기
		int id = Integer.parseInt(request.getParameter("id"));
		
		PostDao postDao = PostDao.getIntance();
		//추가 : 조회수 증가
		int result = postDao.조회수증가(id);				
		//2번 DAO 연결해서 Post postyEntity = 상세보기(id) 함수호출
		if(result == 1) {
			Post postEntity = postDao.글내용(id);
			
			//3qjs request에 postEntity 담기
			request.setAttribute("post", postEntity);
				
			//4번 detail.jsp 로 연결 -> RequestDispatcher 사용하기
			RequestDispatcher dis = request.getRequestDispatcher("/post/detail.jsp");
			dis.forward(request, response);
		}
		else{
			Script.href(response,"/", "잘못된 접근입니다.");
			//response.sendRedirect("/");
		}
	}
	
}
