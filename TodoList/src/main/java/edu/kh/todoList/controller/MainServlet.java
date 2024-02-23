package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "/" 요청 시 위임 받는 Servlet
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TodoListService 참조 변수 선언
		TodoListService service = null;
		
		// RequestDispatcher 참조 변수 선언
		RequestDispatcher dispatcher = null;
		
		try {
			
			// TodoList를 구현한 자식 객체 생성 후 service에 대입(업캐스팅)
			service = new TodoListServiceImpl();
			
			// 전체 목록 + 완료된 Todo 개수가 담긴 Map 얻어오기
			Map<String, Object> map = service.todoListFullView();
			
			// map에 저장된 값 풀어내기
			List<Todo> todoList = (List<Todo>)map.get("todoList");
			int completeCount = (int)map.get("completeCount");
			
			// request 객체에 service에서 얻어온 값을 속성으로 추가
			req.setAttribute("todoList", todoList);
			req.setAttribute("completeCount", completeCount);
			
			
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}
