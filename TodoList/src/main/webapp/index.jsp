<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
	
<%-- Servlet/JSP 프로젝트 실행 시 "/" 주소로 요청이 오면
		 webapp 폴더에 있는 index.html 또는 index.jsp를 이용해 
		 메인 페이지 화면 응답 해준다 
		 
		 (무조건 "/" 요청은 index 파일과 연결이 된다)
		 -> Spring에서는 해결됨
--%>

<%-- jsp 액션 태그 : JSP에서 할수 있는 기능을 담은 태그 --%>

<jsp:forward page="/main"/>
<%-- "/" 요청이 들어온 경우 "/main" 요청을 처리하는 Servlet에게 요청 위임 --%>