<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 범위(scope) 확인</title>
</head>
<body>

  <h3>page scope :        ${pageMessage}</h3>

  <h3>request scope :     ${requestMessage}</h3>

  <h3>session scope :     ${sessionMessage}</h3>
  (다른 브라우저에서 현재 페이지 주소로 접속하면 session이 보이지 않음)

  <h3>application scope : ${applicationMessage}</h3>


</body>
</html>