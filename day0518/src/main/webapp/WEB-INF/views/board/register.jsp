<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Register</h1>
	<p class="mb-4">
		게시글 등록 페이지입니다.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Register Page</h6>
		</div>
		<div class="card-body">


			<div class="form-group">
				<label for="exampleFormControlInput1">제목</label>
				<input type="text"
					class="form-control" id="exampleFormControlInput1"
					placeholder="제목작성" name="title">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">작성자</label>
				<input type="text"
					class="form-control" id="exampleFormControlInput1"
					placeholder="작성자" name="writer">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">내용</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="5" name="content"></textarea>
			</div>
			<button type="button" class="btn btn-primary">목록으로</button>
			<button type="submit" class="btn btn-info">등록하기</button>

		</div>


		<!-- 파라미터를 폼에 감싸서 보내기 -->
		<form id="actionForm">
			<input type="hidden" name="page" value="${pageDTO.page}">
			<input type="hidden" name="amount" value="${pageDTO.amount}">
		</form>
	</div>

</div>
<!-- /.container-fluid -->



<script>

$(document).ready(function(){
	
	var form = $("#actionForm");
	
	// 1. 목록으로 버튼 클릭 시
	// form action = /board/list GET
	// page, amount, type, keyword 안고 간다
	// <button class="btn-primary"> 니까 $(.btn-primary)
	$(".btn-primary").click(function(e){
		
		var type = "${pageDTO.type}"
		var keyword = "${pageDTO.keyword}"
			
		var t = type != "" ? "<input type='hidden' name='type' value='" + type + "'>" : ""
		var k = keyword != "" ? "<input type='hidden' name='keyword' value='" + keyword + "'>" : ""
					
		form.append(t).append(k);
		form.attr("action", "/board/list");
		form.submit();
		
	});
	
	// 2. 등록하기 버튼 클릭 시
	// form action = /board/register POST
	// title, content, writer 안고 간다
	// <button class="btn-info"> 니까 $(.btn-info)
	$(".btn-info").click(function(e){
		
		var title = $("input[name='title']").val();
		var content = $("textarea[name='content']").val();
		var writer = $("input[name='writer']").val();
		
		var t = "<input type='hidden' name='title' value='" + title + "'>"
		var c = "<input type='hidden' name='content' value='" + content + "'>"
		var w = "<input type='hidden' name='writer' value='" + writer + "'>"
		
		form.append(t).append(c).append(w);
		form.attr("action", "/board/register").attr("method", "post");
		form.submit();
		
	});
	
});


	
</script>



<%@ include file="../includes/footer.jsp"%>