package com.cos.blog.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

		public static void href(HttpServletResponse response, String url, String msg) throws IOException {
			//BufferdWriter와 비슷한 getWriter이지만
			//BufferdWriter는 내려쓰기가 없어서 ("안녕 \n") \n을 통해 내려쓰기 해줘ㅑ함
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('"+msg+"');");
			out.print("location.href='"+url+"';");
			out.print("</script>");
		}
		
		public static void back(HttpServletResponse response, String msg) throws IOException {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('"+msg+"');");
			out.print("history.back();");
			out.print("</script>");
		}
}
