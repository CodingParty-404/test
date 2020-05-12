<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시글 조회 페이지 입니다.</h1>
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

			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="btn btn-primary" style = "margin-right:5px;" href="/board/modify?bno=<c:out value="${board.bno}"/>">수정</a></li>
				<li class="nav-item"><a class="btn btn-primary" href="/board/list">목록</a></li>
			</ul>

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
