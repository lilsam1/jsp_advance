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
		if (error.equals("1")) {
			out.print("로그인 성공");
		} else {
			out.print("로그인 실패");
		}

	%>
</body>
</html>