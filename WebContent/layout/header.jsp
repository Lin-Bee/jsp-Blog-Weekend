<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LINBEE BLOG</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<style>
section {
	padding-bottom: 4rem;
}

h2 {
	padding: 4rem 0 2rem 0;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="/">LinBee</a>

			<!-- Toggler/collapsibe Button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Navbar links -->
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">

					<!-- if else구문임 -->
					<c:choose>
						<c:when test="${empty sessionScope.principal}">
							<li class="nav-item"><a class="nav-link" href="/user?cmd=loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="/user?cmd=joinForm">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="#">${principal.username}님의 방문을 환영합니다.</a></li>
							<li class="nav-item"><a class="nav-link" href="/post?cmd=saveForm">글쓰기</a></li>
							<li class="nav-item"><a class="nav-link" href="/user?cmd=updateForm">마이페이지</a></li>
							<li class="nav-item"><a class="nav-link" href="/user?cmd=logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
	</header>