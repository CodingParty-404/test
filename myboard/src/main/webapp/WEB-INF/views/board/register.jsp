<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Register</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Register Form</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form action="/board/register" method="post">
					<label>제목</label>
					<input type="text" name="title" class="form-control mt-4 mb-2" placeholder="제목을 입력해주세요." required value="">
					<label>작성자</label>
					<input type="text" name="writer" class="form-control mt-4 mb-2" required value="sigkgk123" readonly="readonly">
					
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="content"
							placeholder="내용을 입력해주세요" required 
						>아무의미없는내용용용용</textarea>
					</div>
					<button type="submit" class="btn btn-primary mb-3">제출하기</button>
					<a class="btn btn-secondary mb-3" href="/board/list">목록으로</a>
				</form>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<script>
      $(document).ready(function () {
		console.log("Ready.................................")
	})
</script>
<%@include file="../include/footer.jsp"%>
