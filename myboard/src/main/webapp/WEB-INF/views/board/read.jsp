<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">ReadPage</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">ReadForm</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form action="/board/register" method="post">
					<label>제목</label>
					<input type="text" name="title" class="form-control mt-4 mb-2" placeholder="제목을 입력해주세요." required value="<c:out value="${onePost.title}"/>" readonly="readonly">
					<label>작성자</label>
					<input type="text" name="writer" class="form-control mt-4 mb-2" placeholder="제목을 입력해주세요." required value="<c:out value="${onePost.writer}"/>" readonly="readonly">
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="content"
							placeholder="내용을 입력해주세요" required readonly="readonly"
						><c:out value="${onePost.content}"/></textarea>
					</div>
					<button id="toList" class="btn btn-primary mb-3">목록으로</button>
					<button id="tomodi" class="btn btn-secondary mb-3" href="/board/modify?bno=${onePost.bno}">수정하기</button>
					<button id="todel" class="btn btn-secondary mb-3" href="/board/remove?bno=${onePost.bno}">삭제하기</button>
				</form>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<form id="formObj">
</form>
<script>
      $(document).ready(function () {
		console.log("Ready.................................")
		var $formObj = $("#formObj");
		$("#toList").click(function () {
			$formObj.attr("action","/board/list");
			$formObj.submit();
		})
	})
</script>
<%@include file="../include/footer.jsp"%>
