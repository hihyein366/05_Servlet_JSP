<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>EL을 이용해서 request에 세팅된 속성 얻어와 출력하기</h1>
	
	<ul>
		<li>[작성법] : \${K}</li>
		
		<li>기본 자료형 : ${score}</li>
		
		<li>String(객체) : ${address}</li>
		
		<li>
			List 객체 : ${strList}
			
			<!-- EL 구문에서는 배열/리스트 관계 없이 요소 하나 얻어올 때 [index] 사용 -->
			<ul>
				<li>${strList[0]}</li>
				<li>${strList[1]}</li>
				<li>${strList[2]}</li>
				<li>${strList[3]}</li>
			</ul>
		</li>
		
		<li>
			DTO : ${book1}
			<ul>
				<%-- ${K.필드명} : 객체의 필드값을 얻어오기 위한 getter 호출 --%>
				<!-- **** EL을 이용해서 필드 값 얻어오려면 getter가 필수 **** -->
				
				<li>${book1.title}</li> <!-- book1.getTitle() -->
				<li>${book1.writer}</li>
				<li>${book1.price}</li>
			</ul>
		</li>
		
	</ul>
	
	<hr><hr>
	
	<h1> empty 연산자 </h1>
  <pre>
  - \${empty 객체 | 배열 | 리스트}

  - null 또는 빈칸 또는 비어있으면 true
    아니면 false

  - EL은 null을 빈칸으로 표현
    -> null == ""(빈칸)  ==  비어있음(출력할게 없어서 빈칸)
  </pre>

  <ul>
    <li> test1 = null; ->   ${empty test1}</li>
    <li> test2 = ""; ->     ${empty test2}</li>
    <li> test3 = null; ->   ${empty test3}</li>
    <li> test4 = new ArrayList<String>(); ->  ${empty test4}</li> 
    <li> test5 = new ArrayList<String>(); + add()->  ${empty test5}</li>
  </ul>
	
	<hr>
	
	<h1>EL을 이용해 파라미터 출력하기</h1>
	<pre>
	- \${param.Key} 형식으로 지정
	
	* 테스트 진행 시 쿼리스트링 이용 *
	
	- 쿼리스트링 : 주소에 담긴 값을 나타내는 문자열
		-> 요청주소?K=V&K=V&K=V ....
	
	- form태그 GET 방식 제출 or a태그, JS, 주소창에 직접 작성
	</pre>
	
	<h3>\${param.input} : ${param.input}</h3>
	
	<h3>\${param.message} : ${param.message}</h3>
	
	
	
	
	

</body>
</html>