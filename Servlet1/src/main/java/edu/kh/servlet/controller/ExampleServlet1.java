package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; // Tomcat이 제공하는 클래스
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExampleServlet1 extends HttpServlet {

	// GET 방식 요청(method="get"인 form 태그 제출) 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* * 매개 변수 req, resp *
		 *
		 * HttpServletRequest
		 *  - 클라이언트 요청 시 자동 생성되는 객체
		 *  
		 *  - 요청 시 전달된 데이터, 
		 *    요청한 클라이언트 정보, 
		 *    요청을 유연하게 처리하기 위한 객체 등을 제공
		 *    
		 * HttpServletResponse
		 *  - 클라이언트 요청 시 자동 생성되는 객체
		 *  
		 *  - 서버가 클라이언트에게 응답할 수 있는 방법을 제공
		 *    (서버 -> 클라이언트 출력 스트림(PrintWriter) )
		*/
		
		// 요청 시 같이 제출 된 이름, 나이 얻어오기
		// -> 제출된 이름, 나이 == 전달 인자(Parameter) == 전달된 값
		
		/* 요청에 담긴 특정 파라미터 얻어오기 */
		// - String HttpServletRequest.getParameter("name속성값")
		
		// <input name="inputName">에 작성되어 제출된 값 얻어오기
		String inputName = req.getParameter("inputName");
		
		// <input name="inputName">에 작성되어 제출된 값 얻어오기
		String inputAge = req.getParameter("inputAge");
		
		
		System.out.println("[서버] /ex1 요청을 받음");
		
		System.out.println("전달 받은 inputName : " + inputName);
		System.out.println("전달 받은 inputAge : " + inputAge);
		
		
		// ----------------------------------------------------------------------
		
		/* 응답 처리 */
		
		/* 서버(현재 프로젝트)    -> 클라이언트(브라우저)
		 * HTML 코드(문서)를 출력 -> 출력받은 HTML 코드를 해석해서 화면 구성
		 * 
		 * 1) 응답하는 문서(데어터)의 형식과 문자 인코딩 지정
		 * 
		 * 2) 출력용 스트림 얻어오기
		 * 
		 * 3) 스트림을 이용해서 HTML 코드 출력하기
		 */
		
		// 1) 응답하는 문서(데어터)의 형식과 문자 인코딩 지정
		resp.setContentType("text/html; charset=utf-8");
		
		// 2) 출력용 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		// 3) 스트림을 이용해서 HTML 코드 출력하기
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		
		sb.append("<head>");
		sb.append("<title> /ex1 응답 페이지 </title>");
		sb.append("</head>");
		
		sb.append("<body>");
		sb.append(String.format("<h1>%s님의 나이는 %s 입니다</h1>", inputName, inputAge));
		sb.append("</body>");
		
		sb.append("</html>");
		
		// sb에 누적된 html 코드를 스트림을 이용해서 출력
		out.print(sb.toString()); 

		
		
		
		

	}

	
}
