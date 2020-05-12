<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<style>
#dataTable{
	  overflow-y:scroll;
}

</style>
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
					cellspacing="0" >
					<thead>
						<tr>
							<th>번호</th>
							<th>title</th>
							<th>writer</th>
							<th>regDate</th>
							<th>upDate</th>
						</tr>
					</thead>
					<tbody id="is">
					</tbody>
				</table>
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
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
function toDate (obj) {
	return obj.year+"-"+obj.month+"-"+obj.day
}

	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		if(result === "success")
			$("#mymodal").modal("show");
		
		 $.getJSON("http://127.0.0.1:8080/json/getlist", function (arr) {
				var appendTr = "";
				for(var i in arr){
					appendTr = "<tr><td>"+arr[i].bno+"</td>"
					+"<td>"+arr[i].title+"</td>"
					+"<td>"+arr[i].writer+"</td>"
					+"<td>"+toDate(arr[i].regdate.date)+"</td>"
					+"<td>"+toDate(arr[i].moddate.date)+"</td>"
					+"</tr>"
					 $('#is').append(appendTr);
				}
				
			})
	});
</script>
<script>
//Javascript
//스크롤 바닥 감지
var count = 1;

window.onscroll = function(e) {
    //추가되는 임시 콘텐츠
    //window height + window scrollY 값이 document height보다 클 경우,
    	
    if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
    	//실행할 로직 (콘텐츠 추가)
        count++;
    	console.log(count);
    	 $.getJSON("http://127.0.0.1:8080/json/getlist?pageNum="+count, function (arr) {
				var appendTr = "";
					$('#is').children().remove()
				for(var i in arr){
					appendTr = "<tr><td>"+arr[i].bno+"</td>"
					+"<td>"+arr[i].title+"</td>"
					+"<td>"+arr[i].writer+"</td>"
					+"<td>"+toDate(arr[i].regdate.date)+"</td>"
					+"<td>"+toDate(arr[i].moddate.date)+"</td>"
					+"</tr>"
					 $('#is').append(appendTr);
				}
					
					document.documentElement.scrollTop = window.innerHeight/2;
			})
    }
    if(document.documentElement.scrollTop == 0)	{
   		count--;
    	if(count <= 0)
    		count = 1;
    	
    	console.log(count);
    	 $.getJSON("http://127.0.0.1:8080/json/getlist?pageNum="+count, function (arr) {
				var appendTr = "";
					$('#is').children().remove()
				for(var i in arr){
					appendTr = "<tr><td>"+arr[i].bno+"</td>"
								+"<td>"+arr[i].title+"</td>"
								+"<td>"+arr[i].writer+"</td>"
								+"<td>"+toDate(arr[i].regdate.date)+"</td>"
								+"<td>"+toDate(arr[i].moddate.date)+"</td>"

								+"</tr>"
					 $('#is').append(appendTr);
				}
					document.documentElement.scrollTop = window.innerHeight/2; 
			})
   	}
   
};

</script>
<%@include file="../include/footer.jsp"%>

