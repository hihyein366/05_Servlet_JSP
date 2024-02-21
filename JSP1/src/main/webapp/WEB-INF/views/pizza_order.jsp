<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>피자 주문</title>
	
	<!-- css 파일이 위치한 서버 주소 작성 -->
	<!-- "/" (webapp) 폴더를 기준으로 원하는 css파일 까지의 경로를 작성 -->
	<link rel="stylesheet" href="/resources/css/pizza.css">
</head>
<body>
	<main>
		<h1> <%= request.getAttribute("myName") %> 피자 주문 페이지</h1>
		<form action="/pizza/order" method="POST">
	
			<div class="row">
				<label>피자 :</label> 
				<select name="pizza">
					<option>치즈 피자-8000</option>
					<option>콤비네이션 피자-9000</option>
					<option>쉬림프 피자-15000</option>
					<option>더블 포테이토 피자-14000</option>
					<option>하와이안 피자-12000</option>
				</select>
			</div>
	
			<div class="row">
				<label>사이즈 : </label> 
					R <input type="radio" name="size" value="R" checked> 
					L(+4000) <input type="radio" name="size" value="L">
			</div>
	
			<div class="row">
				<label>수량</label>
				<button type="button">-</button>
				<input type="number" name="amount" min="1" max="9" value="1">
				<button type="button">+</button>
			</div>
	
			<button class="order-btn">주문하기</button>
		</form>
	</main>

	<!-- js 파일이 위치한 서버 주소 작성 -->
	<!-- "/" (webapp) 폴더를 기준으로 원하는 js파일 까지의 경로를 작성 -->
	<script src="/resources/js/pizza.js"></script>

</body>
</html>