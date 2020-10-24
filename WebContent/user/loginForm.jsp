<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

	<section>
		<h2>LOGIN</h2>
		<br />
		<div class="container">
	
			<form action="/user?cmd=loginProc" method="post">
				<div class="form-group">
					<label for="username">user name</label>
					 <input type="text" class="form-control" placeholder="Enter username" name="username"  value="${cookie.remember.value}"/>
				</div>
	
				<div class="form-group">
					<label for="password">Password:</label>
					 <input type="password" class="form-control" placeholder="Enter password" name="password" />
				</div>
	
				<div class="form-group form-check">
					<label class="form-check-label"> 
					<input class="form-check-input" type="checkbox" name="remember"> Remember me
					</label>
				</div>
				
				<!-- form 안에 있으면 자동으로 submit됨 -->
				<button type="submit" class="btn btn-primary"  >로그인</button>
			</form>
		</div>
		<br />
	
	</section>

<%@ include file="../layout/footer.jsp" %>