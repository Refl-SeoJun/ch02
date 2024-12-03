package org.zerock.jdbcex.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

/**
 * Servlet implementation class TodoRegisterController
 */
@WebServlet("/todo/register")
public class TodoRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TodoService service = TodoService.INSTANCE;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//등록화면 보여주기
		System.out.println("등록화면 보여주기 요청");
		request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//등록처리
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));
		boolean finished = "yes".equals(request.getParameter("finished"));
		
		TodoDTO dto = TodoDTO.builder()
				.title(title)
				.dueDate(dueDate)
				.finished(finished)
				.build();
		
		try {
			service.register(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//목록화면 보여주기
		//request.getRequestDispatcher("/todo/list").forward(request, response);
		response.sendRedirect("/todo/list");
	}

}
