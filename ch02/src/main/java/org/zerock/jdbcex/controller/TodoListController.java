package org.zerock.jdbcex.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import lombok.extern.log4j.Log4j2;

/**
 * Servlet implementation class TodoListController
 */
@Log4j2
@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TodoService service = TodoService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("url 할일목록 요청");
		
		List<TodoDTO> list = null;
		try {
			list = service.INSTANCE.listAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
