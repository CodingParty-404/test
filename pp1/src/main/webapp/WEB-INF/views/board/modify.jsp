<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시글 수정 페이지 입니다.</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
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
	
	<form id="actionForm">
	
	  
	</form>

</div>
<!-- /.container-fluid -->

<script>
	$(document).ready(function() {
		console.log("ready.....");
		
		var formObj = $("#actionForm");
		console.log(formObj);
		
		//delete button click
		$(".btn-danger").click(function(){
			
			var bno = '<c:out value="${board.bno}"/>';
			
			formObj.append("<input type='hidden' name='bno' value='"+bno+"'>")
			.attr("action","/board/remove")
			.attr("method","post")
			.submit();
			
		});
		
		$(".btn-primary").click(function(){
			formObj.attr("action" , "/board/list").submit();
		});
		
		$(".btn-info").click(function(){
			
			var bno = '<c:out value="${board.bno}"/>';
			var title = $("input[name='title']").val();
			var content = $("textarea[name='content']").val();
			
			console.log(bno, title, content);
			
			formObj.append("<input type='hidden' name='bno' value='"+bno+"'>")
			.append("<input type='hidden' name='title' value='"+title+"'>")
			.append("<input type='hidden' name='content' value='"+content+"'>")
			.attr("action","/board/modify")
			.attr("method","post")
			.submit(); 
			
		});
		
	})
</script>

<%@ include file="../includes/footer.jsp"%>
