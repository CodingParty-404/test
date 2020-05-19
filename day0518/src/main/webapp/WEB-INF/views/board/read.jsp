<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Read</h1>
	<p class="mb-4">
		게시글 조회 페이지입니다.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
		</div>
		<div class="card-body">

			<form action="/board/register" method="post">
				<div class="form-group">
					<label for="exampleFormControlInput1">제목</label> <input type="text"
						class="form-control" id="exampleFormControlInput1"
						placeholder="제목작성" name="title"
						value="<c:out value="${board.title}"/>" readonly>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">작성자</label> <input
						type="text" class="form-control" id="exampleFormControlInput1"
						placeholder="작성자" name="writer"
						value="<c:out value="${board.writer}"/>" readonly>
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">내용</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="5" name="content" readonly><c:out
							value="${board.content}" /> </textarea>
				</div>

			</form>

				<button type="button"  class="btn btn-primary" type="button">목록으로</button>
				<button type="button"  class="btn btn-info" type="button">수정하기</button>
			

		</div>
	</div>

<!-- 파라미터를 폼에 감싸서 보내기 -->
	<form id="formAction">
		<input type="hidden" name="page" value="${pageDTO.page}">
		<input type="hidden" name="amount" value="${pageDTO.amount}">
	</form>

</div>


<script>

	$(document).ready(function(){
		
		var form = $("#formAction");
		
		// 1. 목록으로 버튼 클릭했을 때
		// form action = /board/list GET
		// page, amount, keyword, type 다 안고 간다
		// <button class="btn-primary"> 니까 $(".btn-primary")
		$(".btn-primary").click(function(e){
			
			var type = "${pageDTO.type}"
			var keyword = "${pageDTO.keyword}"
			
			var t = type != "" ? "<input type='hidden' name='type' value='"+ type +"'>" : ""
			var k = keyword != "" ? "<input type='hidden' name='keyword' value='"+ keyword +"'>" : ""
					
			form.append(t).append(k);
			form.attr("action", "/board/list");
			form.submit();
						
		});
		
		
		// 2. 수정하기 버튼 클릭했을 때
		// form action = /board/modify GET
		// bno, page, amount, keyword, type 다 안고 간다
		// <button class="btn-info"> 니까  $(".btn-info")
		$(".btn-info").click(function(e){
			
			var bno = "${board.bno}" // EL이 board로 받은게 BoardVO 
			var type = "${pageDTO.type}"
			var keyword = "${pageDTO.keyword}"
			
			var b = "<input type='hidden' name='bno' value='"+ bno + "'>"
			var t = type != "" ? "<input type='hidden' name='type' value='"+ type +"'>" : ""
			var k = keyword != "" ? "<input type='hidden' name='keyword' value='"+ keyword +"'>" : ""
			
			form.append(b).append(t).append(k);
			form.attr("action", "/board/modify");
			form.submit();
					
		});
				
	})


</script>

<%@ include file="../includes/footer.jsp"%>

