package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizza/order")
public class PizzaOrderServlet extends HttpServlet {
	
	// GET 방식 요청 : form(GET) / a / JS(location.href) / 주소창 직접 입력
	
	// POST 방식 : form(POST), JS(ajax/REST API)
	
	
	// a태그 요청 == GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// JSP로 요청 위임되는 HttpServletRequest 객체에
		// 임의의 값을 추가하기!
		
		String myName = "정혜인";
		
		// Attribute(속성) == 객체의 속성 == 변수(필드)
		req.setAttribute("myName", myName);
		
		
		// pizza_order.jsp가 응답 화면을 대신 만들어 출력할 수 있도록
		// HttpServletRequest, HttpServletResponse를 요청 위임(forward)
		
		// "/"(webapp폴더) 부터 "pizza_order.jsp" 까지의 파일 경로를 작성
		String path = "/WEB-INF/views/pizza_order.jsp";
		
		// RequestDispatcher 객체 생성
		// (요청 위임 JSP 지정 + req/resp 객체 발송)
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 요청 위임
		dispatcher.forward(req, resp);
		
	}

	/* 요청 주소가 같아도 method가 GET/POST로 다른 경우
	   따로 처리하는 코드를 작성할 수 있다 */
	
	// 피자 주문 페이지 요청 처리(POST 방식)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pizza = req.getParameter("pizza"); 
		String size = req.getParameter("size");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		/* 피자 이름, 가격 나누기 */
		String[] arr = pizza.split("-"); // -로 쪼개어 String[] 반환
		// arr == {"치즈 피자", "8000"}
		
		String pizzaName = arr[0]; // "치즈피자"
		int price = Integer.parseInt(arr[1]); // 8000
		
		/* L사이즈면 4000 추가 */
		if(size.equals("L")) price += 4000;
		
		/* 수량 만큼 price에 곱하기 */
		price *= amount;
		
		// pizzaName, price를 요청 위임할 JSP로 넘겨주기 위해 
		// HttpServletRequest 객체에 속성으로 추가
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		
		// 요청 위임할 JSP 경로 지정
		String path = "/WEB-INF/views/order_result.jsp";
		
		// 요청 발송자를 이용해서 JSP 지정 + 요청 위임
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
		
		
	}

	
}
