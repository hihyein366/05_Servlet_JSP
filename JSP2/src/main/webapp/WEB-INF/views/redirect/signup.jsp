<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect 확인 하기</title>
</head>
<body>

	<!-- session에 message가 존재하면 출력됨 -->
	<h1>${message}</h1>
	
	<% // session에 존재하는 속성 중 message를 제거
		session.removeAttribute("message");
	
		// redirect 시 데이터를 유지하기 위해 session을 이용했는데
		// 계속 유지 되어서 1회 출력 후 session에서 데이터 제거함.
	%>
	
	<hr>

	<h1>회원 가입</h1>
	
	<form action="/signup" method="POST">
		<div>
			ID : <input type="text" name="id">
		</div>
	
		<div>
			PW : <input type="password" name="pw">
		</div>
	
		<div>
			PW CHECK : <input type="password" name="pwCheck">
		</div>
		
		<button>회원 가입</button>
	
	</form>
	

</body>
</html>