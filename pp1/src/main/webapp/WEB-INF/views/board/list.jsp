<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<!--  <a class="btn btn-outline-success" href="/board/register" role="button">게시글 작성</a><br> -->
	<button type="button" class="btn btn-outline-success" id="regi">게시글 작성</button>
	
	
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"></h6>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Amount select</label> <select
					class="form-control" id="select">
					<option ${pageMaker.pageDTO.amount == 10? 'selected' : '' }>10</option>
					<option ${pageMaker.pageDTO.amount == 20? 'selected' : '' }>20</option>
					<option ${pageMaker.pageDTO.amount == 30? 'selected' : '' }>30</option>
					<option ${pageMaker.pageDTO.amount == 50? 'selected' : '' }>50</option>
					<option ${pageMaker.pageDTO.amount == 100? 'selected' : '' }>100</option>
				</select>
			</div>

			<div class="form-search">
				<label for="exampleFormControlSelect1">검색할 항목을 골라주세요</label> <select
					class="form-control" id="search">
					<option ${pageMaker.pageDTO.type == 't'? 'selected' : '' } value = "t">제목</option>
					<option ${pageMaker.pageDTO.type == 'c'? 'selected' : '' } value = "c">내용</option>
					<option ${pageMaker.pageDTO.type == 'w'? 'selected' : '' } value = "w">작성자</option>
					<option ${pageMaker.pageDTO.type == 'tc'? 'selected' : '' } value = "tc">제목+내용</option>			
					<option ${pageMaker.pageDTO.type == 'tw'? 'selected' : '' } value = "tw">제목+작성자</option>
					<option ${pageMaker.pageDTO.type == 'cw'? 'selected' : '' } value = "cw">내용+작성자</option>
					<option ${pageMaker.pageDTO.type == 'tcw'? 'selected' : '' } value = "tcw">제목+내용+작성자 </option>
					
				</select>
				<input style = "margin-top :2px" type = "text" id = "keyword" value= "${pageMaker.pageDTO.keyword}"> 
				<button class ="btn btn-outline-success" id = "searchcommit">검색</button>
			</div>

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
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}"></c:out></td>
								<td><a class="clickedTitle" href="${board.bno}"><c:out value="${board.title}"></c:out></a></td>		
								<td><c:out value="${board.content}"></c:out></td>
								<td><c:out value="${board.writer}"></c:out></td>
								<td><c:out value="${board.regdate}"></c:out></td>
								<td><c:out value="${board.moddate}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
						<li class="page-item"><a class="page-link"
							href="${pageMaker.start -1 }">Prev</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.start}" end="${pageMaker.end }"
						var="num">

						<li
							class="page-item ${pageMaker.pageDTO.page == num ? 'active' : '' } ">
							<a class="page-link" href="${num}">${num}</a>
						</li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
						<li class="page-item"><a class="page-link"
							href="${pageMaker.end +1 }">Next</a></li>
					</c:if>
				</ul>
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
				<button type="button" class="btn btn-secondary" data-dismiss="modal">목록으로</button>
			</div>
		</div>
	</div>


	<form id="formAction">
		<input type="hidden" name="page" value="${pageMaker.pageDTO.page}">
		<input type="hidden" name="amount" value="${pageMaker.pageDTO.amount}">

	</form>
</div>

<script>
	$(document).ready(function() {

		var result = '<c:out value="${result}"/>';

		//전달될 form 태그 객체
		var form = $("#formAction");
		
		
		// 글작성 버튼을 눌렀을때
		$("#regi").click(function(e){
			
			// /board/register에 get방식으로
			// 페이지, 어마운트, 타입, 키워드 보낼거임
			var type = "${pageDTO.type}" != "" ? "<input type = 'hidden' name = 'type' value = ${pageDTO.type} >" : ""
			var keyword = "${pageDTO.keyword}" != "" ? "<input type = 'hidden' name = 'keyword' value = ${pageDTO.keyword} >" : ""
					
			
			form.append(type);
			form.append(keyword);
			form.attr("action", "/board/register");
			form.submit(); 
			
		});
		

		//검색버튼을 눌렀을때
		$("#searchcommit").click(function(e) {
			
 			var type = $("#search").val();
			var keyword = $("#keyword").val(); 
			
 			console.log(type);
			console.log(keyword);
			
			var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : ""				
			var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : ""
					
			console.log(t);
			console.log(k);		
			
			
  			form.find("input[name='page']").val("1");
			form.append(t);
			form.append(k);
			form.attr("action", "/board/list");
			form.submit();  
			
		});
		
		// 하단의 페이지 번호 링크를 눌렀을때
		$(".page-link").click(function(e) {

			e.preventDefault();
			window.alert("클릭이벤트");

			var page = $(this).attr("href");
 			var type = $("#search").val();
			var keyword = $("#keyword").val(); 

			var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : null				
			var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : null
			console.log(page);		
			console.log(t);
			console.log(k);	

			form.find("input[name=page]").val(page);
			form.append(t);
			form.append(k);
			form.attr("action", "/board/list");
			form.submit();

		});
		
		
		// 글 제목을 클릭했을 때
		$(".clickedTitle").click(function(e){
			
			//1. a태그의 기본 작동 저지
			e.preventDefault();
			//2. 클릭한 제목의 bno를 가져온다	
			var bno = $(this).attr("href");
 			var type = $("#search").val();
			var keyword = $("#keyword").val(); 

			var str = "<input type='hidden' name='bno' value='" + bno + "' >"
			var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : ""				
			var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : ""
			
			
			form.append(str);
			form.append(t);
			form.append(k);
			form.attr("action","/board/read");
			form.submit();
		});
		
		
		// amount select에 변화가 있을 때	
		$("#select").change(function() {
			
 			var type = $("#search").val();
			var keyword = $("#keyword").val(); 
			var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : ""				
			var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : ""

			form.find("input[name='page']").val("1");
			form.find("input[name='amount']").val($(this).val());
			form.append(t);
			form.append(k);
			form.submit();

		});
		

		if (result !== '') {
			console.log("show modal");
			$('.modal-title').html(result)
			$('#myModal').modal("show");
		}

	})
</script>


<%@ include file="../includes/footer.jsp"%>