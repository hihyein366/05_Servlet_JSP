<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 결과</title>
</head>
<body>
	<h1>피자 : <%= request.getAttribute("pizzaName") %></h1>
	<h1>사이즈 : <%= request.getParameter("size") %></h1>
	<h1>수량 : <%= request.getParameter("amount") %></h1>
	
	<h1>총 가격 : <%= request.getAttribute("price") %></h1>
	
	<hr><hr>
	
	<h1>EL(Expression Language) : 표현 언어</h1>
  <pre>
    JSP의 기본 표현식을 <%-- <%= %> --%>
    조금 더 효율적이고 간단히 작성할 수 있도록 고안된 언어
    (JSP 기본 내장)

    화면에 출력하고자 하는 Java 코드(값, 변수명 등)를
    \${ KEY } 형식으로 작성하면 
    KEY에 해당하는 Value가 화면에 표시됨
  </pre>
  
  <h1>피자 : ${pizzaName}</h1>
  
  <h1>사이즈 : ${param.size}</h1>
  <h1>수량 : ${param.amount}</h1>
  
  <h1>총 가격 : ${price}</h1>

</body>
</html>