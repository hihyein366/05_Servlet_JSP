package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* Servlet/JSP 내장 객체와 범위 */
		
		// 범위 별 내장 객체를 얻어와 여러 값을 세팅, 확인 테스트
		
		
		// 1. page scope -> JSP 확인
		
		// --------------------------------------------------------------
		
		// 2. request scope(== HttpServletRequest)
		// - 요청 받은 Servlet/JSP 위임 받은 Servlet/JSP 에서 유지
		// 	 (위임 계속되면 request도 계속 유지)
		
		req.setAttribute("requestMessage", "request scope 입니다");
		
		// --------------------------------------------------------------

		// 3. session scope(입회, 접속)
		// - 클라이언트가 서버에 첫 요청을 할때 생성
		// 	 (== 클라이언트가 사이트에 접속함)
		
		// - 지정된 세션 만료 시간 또는 브라우저 종료 시까지 유지
		
		// - session이 유지 되는 동안 어디서든 사용 가능
		
		// 1) Session 객체 얻어오기
		HttpSession session = req.getSession();
		
		// 2) Session 객체에 속성 추가하기
		session.setAttribute("sessionMessage", "session scope 입니다.");
		
		// --------------------------------------------------------------
		
		// 4. application scope
		// - 앱 어플리케이션(서버) 당 1개만 존재
		// - 서버 시작 시 생성, 종료 시 소멸
		// 	 (종료 전까지 어디서든지 사용 가능)
		
		ServletContext application = req.getServletContext();
		
		application.setAttribute("applicationMessage", "application scope 입니다");
		
		// --------------------------------------------------------------
		
		// 5. 범위 별 우선순위 확인
		//  (범위가 좁을수록 우선 순위가 높다)
		// page > request > session > application
		
		// 모든 범위에 같은 key로 속성을 추가
		req.setAttribute("str", "REQUEST");
		session.setAttribute("str", "SESSION");
		application.setAttribute("str", "APPLICATION");
		
		
		// --------------------------------------------------------------

		
		// forward(요청 위임)
		String path = "/WEB-INF/views/scope/scope.jsp";
				
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		
		
	}

}
