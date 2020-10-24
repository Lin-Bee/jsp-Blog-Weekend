<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

	<section>
		<h2>게시글쓰기</h2>
		<br />
		<div class="container">
	
			<form action="/post?cmd=saveProc" method="post">
				<div class="form-group">
					<input type="hidden" value="${sessionScope.principal.id}"  name="userId" />
				</div>
				<div class="form-group">
					<label for="title">제목</label>
					 <input type="text" class="form-control" placeholder="Enter title" name="title"  required/>
				</div>
	
				<div class="form-group">
					<label for="password">내용</label>
					 <textarea id="summernote" class="form-control" name="content"></textarea>
				</div>
				
				<!-- form 안에 있으면 자동으로 submit됨 -->
				<button type="submit" class="btn btn-primary"  >글쓰기</button>
			</form>
		</div>
		<br />
	
	</section>
	<script>
      $('#summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>

<%@ include file="../layout/footer.jsp" %>