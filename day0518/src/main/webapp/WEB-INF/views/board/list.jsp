<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Contents Board</h1>
	<p class="mb-4">
		게시판 목록 페이지

		<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div><p><p>
		<div class="card-body">
			<div class="table-responsive">


				<div>
					<div class="input-group mb-3">

						<select class="form-control" id="searchType"
							style="display: inline-block; width: 30%;">
							<option ${pageMaker.pageDTO.type == 't' ? 'selected' : '' }
								value="t">제목</option>
							<option ${pageMaker.pageDTO.type == 'c' ? 'selected' : '' }
								value="c">내용</option>
							<option ${pageMaker.pageDTO.type == 'w' ? 'selected' : '' }
								value="w">작성자</option>
							<option ${pageMaker.pageDTO.type == 'tc' ? 'selected' : '' }
								value="tc">제목+내용</option>
							<option ${pageMaker.pageDTO.type == 'tw' ? 'selected' : '' }
								value="tw">제목+작성자</option>
							<option ${pageMaker.pageDTO.type == 'cw' ? 'selected' : '' }
								value="cw">내용+작성자</option>
							<option ${pageMaker.pageDTO.type == 'tcw' ? 'selected' : '' }
								value="tcw">제목+내용+작성자</option>
						</select> <input type="text" id="keyword" class="form-control"
							placeholder="검색어를 입력하세요" aria-label="Recipient's username"
							aria-describedby="button-addon2"
							value="${pageMaker.pageDTO.keyword}"
							style="display: inline-block; width: 60%;">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button"
								id="button-addon2">검색</button>
						</div>
					</div>
				</div><p><p><p>
				
				<div class="form-search">
					<label for="exampleFormControlSelect1"></label> <select
						class="form-control" id="select"
						style="display: inline-block; width: 30%; float: right;">
						<option ${pageMaker.pageDTO.amount == 10? 'selected' : '' }>10</option>
						<option ${pageMaker.pageDTO.amount == 20? 'selected' : '' }>20</option>
						<option ${pageMaker.pageDTO.amount == 30? 'selected' : '' }>30</option>
						<option ${pageMaker.pageDTO.amount == 50? 'selected' : '' }>50</option>
						<option ${pageMaker.pageDTO.amount == 100? 'selected' : '' }>100</option>
					</select>
					<button class="btn btn-outline-success" id="regi">게시글 작성</button>
				</div><p><p><p>
         
				     
              <!-- 게시판 테이블 시작 -->
				
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
                  <thead>
                    <tr>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>내용</th>
                      <th>작성자</th>
                      <th>등록일</th>
                      <th>최종수정일</th>
                    </tr>
                  </thead>
                  <tbody>
                  <!-- 반복문 + EL -->
                  <!-- list controller가 model에 태워보내준 "list"를 받음 -->
                  <!-- ${list} 의 정체는 service.getList(pageDTO) 이다 -->
                  <!-- 즉, EL은 List<BoardVO>를 받는다 -->
                  <c:forEach items="${list}" var="board">
                    <tr>
                      <td><c:out value="${board.bno }"></c:out></td>
                      <!-- title 클릭하면 이벤트 발생할 수 있도록 a태그 걸기 -->
                      <td>
                      	<a class="clickedTitle" href="${board.bno }"><c:out
											value="${board.title }" /></a>
                      	</td>
                      <td><c:out value="${board.content }"></c:out></td>
                      <td><c:out value="${board.writer }"></c:out></td>
                      <td><c:out value="${board.regdate }"></c:out></td>
                      <td><c:out value="${board.moddate }"></c:out></td>
                    </tr>
                   </c:forEach>
                  </tbody>
                </table>
                
                
                <!-- 페이지네이션 -->
                <!--  ul class 'pagination'에 스타일이 적용되어 있으므로 바꾸면 안됨 -->
                <ul class="pagination">                
                	<!-- 이전 버튼 -->
					<c:if test="${pageMaker.prev}">
						<li class="page-item"><a class="page-link"
							href="${pageMaker.start -1 }">Prev</a></li>
					</c:if>

                	<!-- 페이지 링크 -->
					<c:forEach begin="${pageMaker.start}" end="${pageMaker.end }"
						var="num">
						<li
							class="page-item ${pageMaker.pageDTO.page == num ? 'active' : '' } ">
							<a class="page-link" href="${num}">${num}</a>
						</li>
					</c:forEach>
                	
                	<!-- 다음 버튼 -->
                	<c:if test="${pageMaker.next }">
                		<li class="page-item">
                		<a class="page-link" href="${pageMaker.end+1 }">다음</a>
                		</li>
                	</c:if>                	              	
              </ul>
                                
</div>
</div>
</div>
</div>
<!-- /.container-fluid -->
        
        
    <!-- 모달 -->
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
    
        
        
    <!-- 파라미터를 form에 감싸서 보내기 -->
	<form id="formAction">
		<input type="hidden" name="page" value="${pageMaker.pageDTO.page}">
		<input type="hidden" name="amount" value="${pageMaker.pageDTO.amount}">
	</form>
        
<script>
        $(document).ready(function(){
        	
        	// 컨트롤러 /modify(post) 와 /remove(post)에서
        	// addflashattribute로 "result"를 보낸다
        	// 그거 EL로 받아서 변수에 저장
    		var result = '<c:out value="${result}"/>';
        	// 0. 수정, 삭제 시 나타나는 모달창
			// 컨트롤러 /modify post와 /delete post에서
    		// 넘겨받은 result 값을 모달창으로 보여준다
    		if (result !== '') {
    			$('.modal-title').html(result)
    			$('#myModal').modal("show");
    		}


    		// 파라미터 감싸서 보낼 form 태그 객체를 변수에 저장      	
        	var form = $("#formAction");
        	
        	// 1. 글 제목을 클릭하면
        	// read페이지로 가야하는데 파라미터들을 챙겨가야한다
        	// a class="clickedTitle"이니까 $(".clickedTitle")
			$(".clickedTitle").click(function(e){
			
				e.preventDefault();
			
				var bno = $(this).attr("href")
				var type = $("#searchType").val()
				var keyword = $("#keyword").val()
			
				var b = "<input type='hidden' name='bno' value='" + bno + "'>"
				var t = type != ""? "<input type='hidden' name='type' value='" + type + "'>" : ""
				var k = keyword != ""? "<input type='hidden' name='keyword' value='" + keyword + "'>" : ""
		
				form.append(b).append(t).append(k);
				form.attr("action", "/board/read");
				form.submit();
		
			});
        	
        	
        	// 2. 페이지네이션의 숫자(a링크)를 클릭하면
        	// 현재 page가 바뀐다
        	// a class="page-link"이니까 $(".page-link")
			$(".page-link").click(function(e) {

				e.preventDefault();
		

				var page = $(this).attr("href");
 				var type = $("#searchType").val();
				var keyword = $("#keyword").val(); 

				var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : null				
				var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : null

				form.find("input[name='page']").val(page);
				form.append(t);
				form.append(k);
				form.attr("action", "/board/list"); // form의 action을 지정하지 않으면 현재 브라우저의 URI 컨트롤러로 간다. list에서 클릭했으니 /list로 간다
				form.submit();

			});
        	
        	
        	
        	// 3. select에 변화가 감지되면
        	// 현재 amount로 바뀌고
        	// page는 1이 된다
        	// <select id="select" 니까 $("#select")
        	$("#select").change(function(e){
        		
        		var amount = $(this).val();
        		
        		var type = $("#searchType").val();
				var keyword = $("#keyword").val(); 

				var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : null				
				var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : null
  		
        		form.find("input[name='page']").val("1");
        		form.find("input[name=amount]").val(amount);
        		form.append(t).append(k);
        		
        		form.attr("action", "/board/list"); // form의 action을 지정하지 않으면 현재 브라우저의 URI 컨트롤러로 간다. list에서 클릭했으니 /list로 간다
        		form.submit();
        		
        	});
        		
        	
        	// 4. 게시글 작성 버튼을 클릭하면
        	// page, amount, type, keyword 안고간다
			// <button id = regi>니까 $(#regi)
			$("#regi").click(function(e){
				
        		var type = $("#searchType").val();
				var keyword = $("#keyword").val(); 
				
				var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : null				
				var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : null
				
				form.append(t).append(k);
        		form.attr("action", "/board/register");
				form.submit();		
						
			});
			
			
			// 5. 검색 버튼 눌렀을 때
			// type, keyword, amount 날아가고
			// page는 1이 된다
			// 
			$("#button-addon2").click(function(e){
				
        		var type = $("#searchType").val();
				var keyword = $("#keyword").val(); 
				
				var t = type != ""? "<input type = 'hidden' name = 'type' value = '"+ type +"' >" : null				
				var k = keyword != "" ? "<input type = 'hidden' name = 'keyword' value = '"+ keyword +"' >" : null
				
				form.find("input[name=page]").val("1");
				form.append(t).append(k);
				form.attr("action", "/board/list"); // form의 action을 지정하지 않으면 현재 브라우저의 URI 컨트롤러로 간다. list에서 클릭했으니 /list로 간다
				form.submit();
				
			});               	
        })
        
</script>

<%@ include file="../includes/footer.jsp"%>