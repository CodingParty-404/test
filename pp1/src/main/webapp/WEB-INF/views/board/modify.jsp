<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Register Page</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">

			<form action="/board/modify?bno=<c:out value="${board.bno}"/>" method="post">
			
				<div class="form-group">
					<label for="exampleFormControlInput1">제목</label> <input
						type="text" class="form-control" id="exampleFormControlInput1"
						placeholder="제목작성" name = "title" value="<c:out value="${board.title}"/>">
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">작성자</label> <input
						type="text" class="form-control" id="exampleFormControlInput1"
						placeholder="작성자" name = "writer" value="<c:out value="${board.writer}"/>" readonly>
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">내용</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="5" name = "content"><c:out value="${board.content}"/></textarea>
				</div>
				
				<button type="submit" class="btn btn-primary">수정</button>
			</form>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
<script>
	$(document).ready(function() {
		console.log("AAAAA");
	})
</script>

<%@ include file="../includes/footer.jsp"%>
