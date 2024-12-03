package org.zerock.jdbcex.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.jdbcex.service.TodoService;

/**
 * Servlet implementation class TodoRemoveController
 */
@WebServlet("/todo/delete")
public class TodoRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TodoService service = TodoService.INSTANCE;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoRemoveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long tno = Long.parseLong(request.getParameter("tno"));
		try {
			service.delete(tno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/todo/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
