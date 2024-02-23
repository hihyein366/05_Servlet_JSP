package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/detail")
public class TodoDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TodoListService service = null;
		
		try {
			service = new TodoListServiceImpl();
			
			// 쿼리스트링으로 전달받은 index(파라미터) 얻어오기
			int index = Integer.parseInt(req.getParameter("index"));
			
			// index 번째 Todo를 조회하는 서비스 호출 후 결과 반환받기
			Todo todo = service.todoDetailView(index);
			
			if(todo == null) { // index 잘못 입력
				// redirect
				HttpSession session = req.getSession();
				session.setAttribute("message", "index 올바르지 않다!");
				resp.sendRedirect("/");
				
			} else {
				
				// forward
				req.setAttribute("todo", todo); // 위임된 JSP에서 쓸수 있게 세팅
				
				String path = "/WEB-INF/views/todo/detail.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
			}
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
