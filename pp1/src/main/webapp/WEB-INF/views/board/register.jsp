<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시글 등록 페이지 입니다.</h1>
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


			<div class="form-group">
				<label for="exampleFormControlInput1">제목</label> <input type="text"
					class="form-control" id="exampleFormControlInput1"
					placeholder="제목작성" name="title">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">작성자</label> <input type="text"
					class="form-control" id="exampleFormControlInput1"
					placeholder="작성자" name="writer">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">내용</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="5" name="content"></textarea>
			</div>
			<button type="button" class="btn btn-primary">목록으로</button>
			<button type="submit" class="btn btn-info">등록완료</button>

		</div>

		<form id="actionForm">
			<input type="hidden" name="page" value="${pageDTO.page}">
			<input type="hidden" name="amount" value="${pageDTO.amount}">
		</form>
	</div>

</div>
<!-- /.container-fluid -->
<script>
	$(document).ready(function() {
		var form = $("#actionForm");
		console.log(form);

		
		//목록으로 버튼 클릭 시 
		$(".btn-primary").click(function() {
			
			var p = "${pageDTO.page}"
			var a = "${pageDTO.amount}"
			var type = "${pageDTO.type}" != "" ? "<input type = 'hidden' name = 'type' value = ${pageDTO.type} >" : ""
			var keyword = "${pageDTO.keyword}" != "" ? "<input type = 'hidden' name = 'keyword' value = ${pageDTO.keyword} >" : ""
			
			form.append(type)
			.append(keyword);
			form.find("input[name='page']").val(p);
			form.find("input[name='amount']").val(a);
			form.attr("action","/board/list")
			.attr("method","get");
			form.submit();
		});

		
		//등록완료 버튼 클릭 시
		$(".btn-info").click(function() {
			
			var title = $("input[name=title]").val();
			var writer = $("input[name=writer]").val();
			var content = $("textarea[name=content]").val();
			
			console.log(title);
			console.log(writer);
			console.log(content);
			
			form.append()
			.append("<input type='hidden' name='title' value="+title+">")
			.append("<input type='hidden' name='writer' value="+writer+">")
			.append("<input type='hidden' name='content' value="+content+">")
			.attr("action","/board/register")
			.attr("method","post")
			.submit();
		});
	})
</script>


<%@ include file="../includes/footer.jsp"%>
