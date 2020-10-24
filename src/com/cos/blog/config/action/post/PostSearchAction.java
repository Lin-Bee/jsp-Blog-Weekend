package com.cos.blog.config.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;
import com.cos.blog.utils.Script;

public class PostSearchAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("keyword") == null || request.getParameter("keyword").equals("")) {
			Script.back(response, "검색키워드가 없습니다.");
			return;
		} 
		
		//최초 요청시에는 0, 그 다음 부터는 +1 혹은 -1
		int page = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword");
		
		PostDao postDao = PostDao.getIntance();
		List<Post> posts = postDao.글목록(page,keyword);
		
		//전체페이지 SELECT count(*)FROM post;
		int count = postDao.글갯수(keyword);
		
		int lastPage = (count % 3) == 0 ? (count/3) : (count/3)+1;
		lastPage = lastPage - 1;
		                                                   //연산자   true      : false
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("posts", posts);
		
		//자바 유틸.post
		RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
		dis.forward(request, response);
		
		//글목록에서 마지막페이지 오버로딩하는거
	}

}
