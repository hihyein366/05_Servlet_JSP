package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<String> nameList = new ArrayList<String>();
		
		nameList.add("김자");
		nameList.add("미댜");
		nameList.add("고디");
		nameList.add("기쥐");
		nameList.add("공고");
		nameList.add("검색");
		nameList.add("이리스");
		nameList.add("졸리다");
		nameList.add("집가래");
		
		
		// List에 입력 받은 이름(파라미터)가 존재하는지 확인
		
		String inputName = req.getParameter("inputName"); // 입력 받은 이름
		
		if(nameList.contains(inputName)) {
			
			String searchMessage = String.format("%s는 %d번째 인덱스에 존재함", inputName, nameList.indexOf(inputName));
			
			// forward 시 request 유지됨!
			req.setAttribute("searchMessage", searchMessage);
			
			String path = "/WEB-INF/views/practice/search_result.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} else { // 이름 존재하지 않는 경우
			String searchMessage = inputName + "은/는 존재하지 않습니다.";
			
			HttpSession session = req.getSession(); // session 객체 얻어오기
			
			session.setAttribute("searchMessage", searchMessage);
			
			// "/error" redirect
			resp.sendRedirect("/error"); // redirect는 무조건 GET 방식
		}
		
		
	}
	

	
}
