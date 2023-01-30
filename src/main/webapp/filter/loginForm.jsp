<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<%
		String error = request.getParameter("error");
		if (error != null && error.equals("1")) {
			out.print("<h4>아이디를 입력해주세요</h4>");
		}
	%>
	<form name="frmLogin" method="post" action="loginForm_process.jsp">
		<p>아이디 : <input type="text" name="id">
		<p>비밀번호 : <input type="text" name="passwd">
		<p><input type="submit" value="로그인">
	</form>
</body>
</html>