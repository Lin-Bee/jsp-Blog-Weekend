package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.model.Post;

//http://localhost:8080/blog/            .do
//모든 .do요청은 FrontController를 탄다
@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentController() {
		super();

	}

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/comment요청됨");
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
