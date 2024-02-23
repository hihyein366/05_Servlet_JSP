<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>${todo.title}</title>

<style>
	.detail {
		white-space: pre-wrap;
	}
</style>

</head>
<body>
	<ul>
		<li>제목 : ${todo.title}</li>
		<li>
			완료 여부 :
			<c:if test="${todo.complete}">O</c:if>
			<c:if test="${not todo.complete}">X</c:if>
		</li>
		
		<li>등록일 : ${todo.regDate}</li>
		
		<li class="detail">${todo.detail}</li>
	
	</ul>

</body>
</html>