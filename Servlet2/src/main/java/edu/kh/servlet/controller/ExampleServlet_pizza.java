package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ex3")
public class ExampleServlet_pizza extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 얻어오기
		String pizza = req.getParameter("pizza"); 
		String handle = req.getParameter("handle");
		String ordererName = req.getParameter("ordererName"); 
		String ordererAddress = req.getParameter("ordererAddress");
		
		String[] options = req.getParameterValues("opt");
		
		System.out.println("[서버] /ex3 요청됨");
		
		int price = 0;
		
		switch(pizza) {
		case "치즈" : price += 8000; break;
		case "페퍼로니" : 
		case "고구마" : price += 9000; break;
		case "바비큐" : price += 10000; break;
		}
		
		
		
		
		if(handle.equals("sweetpotato")) price += 3000;
		else if(handle.equals("cheese")) price += 2000; 
		
		if(options != null) {
			for (String opt : options) {
				
				switch(opt) {
				case "피클" : price += 500; break;
				case "핫소스" :
				case "치즈가루" : price += 300; break;
				case "갈릭소스" : price += 800; break;
				}
			}
		}
		
		// 응답 형태 지정
		resp.setContentType("text/html; charset=utf-8");
		
		// 응답 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		
		sb.append("<head>");
		sb.append("<title>");
		sb.append(String.format("%s님의 주문 영수증", ordererName));
		sb.append("</title>");
		sb.append("</head>");
		
		sb.append("<body>");
		
		sb.append(String.format("<h3>주문자명 : %s 고객님</h3>", ordererName));
		
		sb.append(String.format("<h3>주소 : %s</h3>", ordererAddress));
		
		sb.append("<ul>");
		sb.append(String.format("<li>피자 : %s피자</li>", pizza));
		
		if (handle.equals("sweetpotato")) handle = "고구마 크러스트";
		else if (handle.equals("cheese")) handle = "치즈 크러스트";
		else handle = "그냥 손잡이";
		sb.append(String.format("<li>손잡이 : %s</li>", handle));
		
		
		if(options != null) {
			sb.append("<li>");
			sb.append("선택한 옵션 : ");
			for (String opt : options) sb.append(opt + " / ");
			sb.append("</li>");
		}
		sb.append("</ul>");

		sb.append(String.format("<h3>금액 : %d원", price));
				
		sb.append(String.format("<h6>배달팁 +5700 <br> 최종금액 : %d원</h6>", price+5700));
		
		sb.append("</body>");
		
		sb.append("</html>");
		
		out.print(sb.toString());
	
	}
	
	
	


}
