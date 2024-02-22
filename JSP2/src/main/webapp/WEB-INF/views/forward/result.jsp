<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 찾기 결과</title>
</head>
<body>
	<h1>${message}</h1>
	(page -> request -> session -> application)
	
	<h1>${requestScope.message}</h1>
	(request scope의 값을 얻어옴)

</body>
</html>