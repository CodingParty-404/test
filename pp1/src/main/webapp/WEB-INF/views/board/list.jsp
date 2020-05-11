<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<h6 class="m-0 font-weight-bold text-primary">${result }</h6>
			
			
		</div>
		<div class="card-body">
			<div class="table-responsive">


				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items = "${list}" var = "board" >
						<tr>
							<td> <c:out value = "${board.bno}"> </c:out> </td>
							<td><a href="/board/read?bno=<c:out value = "${board.bno}"/>"> <c:out value = "${board.title}"> </c:out> </a></td>
							<td> <c:out value = "${board.content}"> </c:out> </td>
							<td> <c:out value = "${board.writer}"> </c:out> </td>
							<td> <c:out value = "${board.regdate}"> </c:out> </td>
							<td> <c:out value = "${board.moddate}"> </c:out> </td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

<div id="myModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<script>
	$(document).ready(function() {

		
		var result = '<c:out value="${result}"/>';
	
		if(result !== ''){
			console.log("show modal");
			$('.modal-title').html(result)
			$('#myModal').modal("show");
		}
	})        
       
        </script>


<%@ include file="../includes/footer.jsp"%>