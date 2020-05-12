<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
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
			<h1>${result}</h1>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>번호</th>
							<th>title</th>
							<th>writer</th>
							<th>regDate</th>
							<th>upDate</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
						<tr>
							<td><a href="/board/read?bno=<c:out value="${board.bno}"/>"><c:out value="${board.bno}"/></a></td>
							<td><c:out value="${board.title}"/></td>
							<td><c:out value="${board.writer}"/></td>
							<td><c:out value="${board.regdate}"/></td>
							<td><c:out value="${board.moddate}"/></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
						    <c:forEach begin="0" end="10">
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
						    </c:forEach>
					    <li class="page-item"><a class="page-link" href="#">Next</a></li>
					  </ul>
					</nav>
				</div>
			</div>
			<a class="btn btn-primary" href="/board/register">게시글작성</a>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- modal -->
<div id="mymodal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>성공했습니다.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
      </div>
    </div>
  </div>
</div>

<!-- SCRPIT -->
<script>
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		if(result === "success")
			$("#mymodal").modal("show");
	});
</script>
<%@include file="../include/footer.jsp"%>

