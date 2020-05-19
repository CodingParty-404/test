<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
    
    
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Modify</h1>
	<p class="mb-4">
		게시글 수정 페이지입니다.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Modify Page</h6>
		</div>
		<div class="card-body">
		    
			<div class="form-group">
				<label>Bno</label> <input class="form-control" name='bno' readonly="readonly" value="${board.bno}">
			</div>
			<div class="form-group">
				<label>Writer</label> <input class="form-control" name='writer'  value="<c:out value="${board.writer }"/>" 
				readonly="readonly">
			</div>
			<div class="form-group">
				<label>Title</label> <input class="form-control" name='title'
				 value="<c:out value="${board.title }"/>">
			</div>

			<div class="form-group">
				<label>Text area</label>
				<p>
				 <textarea class="form-control" rows="3" name='content'><c:out value="${board.content }"/></textarea>
				</p>
			</div>
	
			<button type="button"  class="btn btn-primary" type="button">목록으로</button>
			<button type="button"  class="btn btn-info" type="button">수정확인</button>
			<button type="button"  class="btn btn-danger" type="button">삭제</button>
			
		</div>
	</div>
	
<!-- 파라미터를 폼에 감싸서 보내기 -->	
	<form id="formAction">
		<input type="hidden" name="page" value="${pageDTO.page}">
		<input type="hidden" name="amount" value="${pageDTO.amount}">	
	</form>

</div>
<!-- /.container-fluid -->

<script>
	$(document).ready(function(){
	
		
		var form = $("#formAction")
		
		// 1. 목록으로 버튼 클릭 시
		// form action = /board/list GET
		// page, amount, keyword, type 다 안고 간다
		// <button class="btn-primary"> 니까 $(".btn-primary")
		$(".btn-primary").click(function(e){
			
			var type = "${pageDTO.type}"
			var keyword = "${pageDTO.keyword}"
			
			var t = type != "" ? "<input type='hidden' name='type' value='" + type + "'>" : ""
			var k = keyword != "" ? "<input type='hidden' name='keyword' value='" + keyword + "'>" : ""
					
			form.append(t).append(k);
			form.attr("action", "/board/list");
			form.submit();
			
		});
		
		
		// 2. 수정완료 버튼 클릭 시
		// form action = /board/modify POST
		// bno, page, amount, keyword, type 다 안고 간다
		// <button class="btn-info" 니까 $(".btn-info")
		$(".btn-info").click(function(e){
			
			var bno = "${board.bno}"
			var title = $("input[name='title']").val();
			var content = $("textarea[name='content']").val();
			var type = "${pageDTO.type}"
			var keyword = "${pageDTO.keyword}"
			
			var b = "<input type='hidden' name='bno' value='" + bno + "'>"
			var tt = "<input type='hidden' name='title' value='" + title + "'>"
			var c = "<input type='hidden' name='content' value='" + content + "'>"
			var t = type != "" ? "<input type='hidden' name='type' value='" + type + "'>" : ""
			var k = keyword != "" ? "<input type='hidden' name='keyword' value='" + keyword + "'>" : ""
							
			form.append(b).append(tt).append(c).append(t).append(k);
			form.attr("action", "/board/modify");
			form.attr("method", "post");
			form.submit();
					
		});
		
		// 삭제 버튼 클릭 시
		// form action = /board/remove POST
		// bno, page, amount, keyword, type 다 안고 간다
		// <button class="btn-danger" 니까 $(".btn-danger")
		$(".btn-danger").click(function(e){
			
			var bno = "${board.bno}"
			var title = $("input[name='title']").val();
			var content = $("textarea[name='content']").val();
			var type = "${pageDTO.type}"
			var keyword = "${pageDTO.keyword}"
				
			var b = "<input type='hidden' name='bno' value='" + bno + "'>"
			var tt = "<input type='hidden' name='title' value='" + title + "'>"
			var c = "<input type='hidden' name='content' value='" + content + "'>"
			var t = type != "" ? "<input type='hidden' name='type' value='" + type + "'>" : ""
			var k = keyword != "" ? "<input type='hidden' name='keyword' value='" + keyword + "'>" : ""
								
			form.append(b).append(tt).append(c).append(t).append(k);
			form.attr("action", "/board/remove");
			form.attr("method", "post");
			form.submit();
			
		});
	
	})


</script>


<%@ include file="../includes/footer.jsp"%>