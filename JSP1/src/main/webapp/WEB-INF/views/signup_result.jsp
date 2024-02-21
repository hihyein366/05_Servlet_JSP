<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- HTML(또는 마크업 언어) 주석 -->
<%-- JSP 전용 주석 
1) JSP에 작성된 Java 코드 주석 처리 시 사용
2) JSP 전용 주석은 컴파일 단계에서 걸러지기 때문에 응답 화면(브라우저)에서 볼 수 없음
--%>
    
<%--
	<%@ %> : JSP 지시자 -> JSP 관련 설정하는 태그
	
--%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
</head>
<body>
	<h2>회원 가입 결과 페이지 입니다</h2>
	
	<%--
		request 변수 == 전달 받은 HttpServletRequest 객체를 참조하는 변수
		
		<% %> 태그 : Scriptlet(스크립틀릿) JSP에서 자바 코드를 작성할 수 있게하는 태그
																			 <% Java 코드 %> 형식으로 작성
		
		<%= %> 태그 : Expression(표현식) JSP에서 자바의 값을 HTML 화면에 출력(표현)하는 태그
									(Java 값 -> HTML 코드로 변환)
	--%>
	
	<% 
		// 전달 받은 파라미터 얻어오기
		String inputId = request.getParameter("inputId");
		String inputPw = request.getParameter("inputPw");
		String inputPwCheck = request.getParameter("inputPwCheck");
		String inputName = request.getParameter("inputName");
		String inputAge = request.getParameter("inputAge");
	%>
	
<%-- 	
	<%=inputId %>
	<%=inputPw %>
	<%=inputPwCheck %>
	<%=inputName %>
	<%=inputAge %> 
--%>
	
	
	<% if(!inputPw.equals(inputPwCheck)) { %>
		<h3>비밀번호가 일치하지 않다..!!</h3>
	
	<% } else if(Integer.parseInt(inputAge) < 14) { %>
		<h3>14세 이상만 가입 가능 하다 ㅡ,.ㅡ</h3>
		
	<% } else { %>
		<h3>가입 성공</h3>
	
		<ul>
			<li>ID : <%=inputId %></li>
			<li>PW : <%=inputPw %></li>
			<li>NAME : <%=inputName %></li>
			<li>AGE : <%=inputAge %></li>
		</ul>
	
	<% } %>	
	
	
	
	
	
	

</body>
</html>