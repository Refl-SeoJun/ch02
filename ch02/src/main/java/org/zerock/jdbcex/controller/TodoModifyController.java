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
 * Servlet implementation class TodoModifyController
 */
@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TodoService service = TodoService.INSTANCE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long tno = Long.parseLong(request.getParameter("tno"));
		//2.글번호로 글 조회하기
		TodoDTO dto=null;
		try {
			dto = service.get(tno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.조회된 내용을 보내면서 해당페이지 열기
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Long tno = Long.parseLong(request.getParameter("tno"));
		String title = request.getParameter("title");
		LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));
		boolean finished = "yes".equals(request.getParameter("finished"));
		System.out.println(title);
		
		TodoDTO dto = TodoDTO.builder()
				.tno(tno)
				.title(title)
				.dueDate(dueDate)
				.finished(finished)
				.build();
		try {
			service.update(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/todo/list");
		
	}

}
