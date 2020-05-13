<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  http://localhost:8080/board/read?bno=300 -->
<h1> read page </h1>

<div>
	<input type='text' name='reply' value="Sample">
	<input type='text' name='replyer' value="hong">
	<button id='regBtn'>Register</button>
</div>

<style>
.replyList {
	display: flex;
	flex-direction: column;
}
.box {
	width: 100vw;
	height: 10vh;
	border: 1px solid green;
	margin: 0.3em;
}
</style>



<div class = "replyList">

</div>

<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
  


<script>
	$(document).ready(function(){
		
		var replyList = $('.replyList');
		
		// 댓글 등록
		// p.403
		// 
	  $("#regBtn").click(function(e){
		  var reply = {bno: 999920 , reply: "Test Test", replyer: "kang"};
		  $.ajax({
			  type: 'post',
			  url:'/replies/new',
			  data: JSON.stringify(reply),
			  contentType: "application/json; charset=utf-8",
			  success: function(result){
				  alert(result);
				  replyList.html("");
				  getList();
			  }
		  })		  
	  });
		replyList.click(function (e) {
			console.log($(e.target).attr("class"));
			
		})
// 	$(".repDel").click(function (e) {
// 		console.log(this);
// 	})
// 	$(".repMod").click(function (e) {
// 		console.log(this);
// 	})
		
		// 정상 작동하는 코드입니다
		getList();
		
		// 함수로 만들어서 실행해야지
		function getList(){
			$.getJSON("http://127.0.0.1:8080/replies/all/999920", function(data){
				// 돔작업은 최소화해야 한다
				var str = "";
				for(var i = 0; i < data.length; i++){
					str += "<div class='box'>"
							+"rno: "+data[i].rno 
							+" reply: "+data[i].reply
							+" replyer: "+data[i].replyer
							+ "<button class=replDel>DEL</button>"
							+ "<button class=replMod>MOD</button>"
							+ "</div>";
				}
				replyList.append(str);
			  })  
		  }		  
	  });
	
	
</script>


</body>
</html>