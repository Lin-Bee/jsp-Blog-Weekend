package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.config.action.user.UserJoinFormAction;
import com.cos.blog.config.action.user.UserJoinProcAction;
import com.cos.blog.config.action.user.UserLoginFormAction;
import com.cos.blog.config.action.user.UserLoginProcAction;
import com.cos.blog.config.action.user.UserLogoutProcAction;
import com.cos.blog.config.action.user.UserUpdateFormAction;
import com.cos.blog.config.action.user.UserUpdateProcAction;

//http://localhost:8080/blog/            .do
//모든 .do요청은 FrontController를 탄다
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();

	}

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/user요청됨");
		String cmd = request.getParameter("cmd");
		System.out.println("cmd :" + cmd);
		
		Action action=route(cmd);
		if(action !=null) action.excute(request, response);
	}

	private Action route(String cmd) {
		if (cmd.equals("joinForm")) {
			// 회원가입이면 회원가입페이지 redirect
			//response.sendRedirect("/user/joinForm.jsp");
			return new UserJoinFormAction();
			
		} else if (cmd.equals("loginForm")) {
			// 로그인페이지도 redirect
			return new UserLoginFormAction();

		} else if (cmd.equals("updateForm")) {
			// 회원수정페이지 model > Dispatcher
			return new UserUpdateFormAction();

		} else if (cmd.equals("joinProc")) {
			return new UserJoinProcAction();

		} else if (cmd.equals("loginProc")) {
			return new UserLoginProcAction();

		} else if (cmd.equals("updateProc")) {
			return new UserUpdateProcAction();

		} else if (cmd.equals("logout")) {
			return new UserLogoutProcAction();

		} else if (cmd.equals("detail")) {
			// 로그인페이지도 dispatcher
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}
