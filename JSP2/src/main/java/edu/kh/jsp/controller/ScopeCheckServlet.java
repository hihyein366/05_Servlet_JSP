package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/scope/check")
public class ScopeCheckServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String path = "/WEB-INF/views/scope/check.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	
	}

}
