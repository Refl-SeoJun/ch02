package org.zerock.jdbcex.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

/**
 * Servlet implementation class TodoLookUpController
 */
@WebServlet("/todo/read")
public class TodoReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TodoService service = TodoService.INSTANCE;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long tno = Long.parseLong(request.getParameter("tno"));
		//2.글번호로 글 조회하기
		TodoDTO dto = null;
		try {
			dto = service.get(tno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.조회된 내용을 보내면서 해당페이지 열기
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}