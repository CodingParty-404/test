<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <form method="POST">
        <input type="text" name="username">
        <input type="text" name="password">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="checkbox" name="remember-me">remember-me
        <button>LOGIN</button>

    </form>
</body>

</html>