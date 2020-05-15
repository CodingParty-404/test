<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> custom login </h1>

<!--  p.632 -->
<form method="post">
<input type= 'text' name='username'>
<input type= 'text' name='password'>
<input type= 'hidden' name='${_csrf.parameterName }' value='${_csrf.token }' />
<input type= 'checkbox' name='remember-me'> Remember Me
<button>LOGIN</button>

</form>



</body>
</html>