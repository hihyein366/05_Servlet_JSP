<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%-- JSTL(Jsp Standard Tag Library) 
    - JSP에서 자주 사용하는 Java 기능(if, for 등)을  태그 형식으로 만들어 제공
    - JSP 개발을 간소화하고 유지 관리를 용이하게 하는 강력한 도구
--%>

<%-- JSTL 라이브러리를 현재 JSP에서 사용하겠다는 JSP 지시자 작성 --%>

<%-- c == core (if, for문 등) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- fn == function (길이, 자르기, 나누기) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
	<h1>Todo List</h1>
	
	<!-- /io_test/TodoList.dat 파일에 저장된 List<Todo>를 읽어와 화면에 모두 출력 -->

	<h3>전체 Todo 개수 : ${fn:length(todoList)} 	/   완료된 Todo 개수 : ${completeCount} </h3>
	
	<hr>
	
  <form action="/todo/add"> <!-- method 미작성 시 GET 기본값 -->
    <h4> 할 일 추가 </h4>
    <div>
    	제목 : <input type="text" name="title">
    </div>
    <div>
    	<textarea name="detail" cols="50" rows="3" placeholder="상세 내용"></textarea>
    </div>
    <button>추가</button>
  </form>
	
	<hr>
	
	<table border="1" style="border-collapse: collapse;">
	
		<thead>
			<tr>
				<th>할 일 제목</th>
				<th>완료 여부</th>
				<th>등록 날짜</th>
			</tr>
		</thead>
		
		<tbody>
		
			<%-- c:foreach == JSTL의 향상된 for문 
				items : 순차 접근할 List, 배열
				var : 하나씩 꺼내서 저장할 변수 이름 지정
				varStatus : 반복 상태 관련 객체(몇 번 인덱스, 몇 바퀴째인지 이런거..)
			--%>
			<c:forEach var="todo" items="${todoList}" varStatus="vs">
			
				<tr>
					<td>
					<%-- 쿼리스트링 : 주소에 포함된 데이터가 담긴 문자열
							 ?key=value 형태
					 --%>
						<a href="/todo/detail?index=${vs.index}">${todo.title}</a> 
					</td>
					
					<th>
						<%-- c:if (조건문, else 없음) 
								 test 속성 : 조건식을 작성하는 속성
								 not == ! (논리 부정 연산자)
						--%>
						<c:if test="${todo.complete}">O</c:if>
						<c:if test="${not todo.complete}">X</c:if>
					</th>
					
					<td>${todo.regDate}</td>
				</tr>
			
			</c:forEach>
		
		</tbody>
	
	</table>
	
	<!-- JSP에서 Java(EX,JSTL), Front(HTML, CSS, JS) 중 
	   	 JAVA가 해석 우선 순위가 높다(먼저 해석 됨)
	
	-->
	
	
	<%-- session scope에 message 속성이 있다면 --%>
	<c:if test="${ not empty sessionScope.message }">
	<script>
		// EL을 이용해서 String을 출력할 때 꼭 앞쪽에 " " 추가하기@@!
		const message = "${message}";
		alert(message);
	</script>
	
	<%-- sessionScope.message를 한 번만 출력 후 제거하기 --%>
	<c:remove var="message" scope="session" />
	
	</c:if>

</body>
</html>