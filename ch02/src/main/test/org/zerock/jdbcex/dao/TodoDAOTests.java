package org.zerock.jdbcex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zerock.jdbcex.domain.TodoVO;

public class TodoDAOTests {
	
	private TodoDAO dao;
	
	@Before
	public void ready() {
		dao = new TodoDAO();
	}
	
	@Test
	public void testGetTime() throws SQLException {
		System.out.println(dao.getTime());
	}
	
	@After
	public void end() {
		System.out.println("테스트 끝");
	}
	
	@Test
	public void testInsert() throws SQLException {
		TodoVO vo = TodoVO.builder().title("sample test").dueDate(LocalDate.now()).build();
		dao.insert(vo);
	}
	
	@Test
	public void testSelectAll() throws SQLException {
		dao.selectAll().forEach(item -> System.out.println(item));
	}
	
	@Test
	public void testSelectOne() throws SQLException {
		System.out.println(dao.selectOne(4L));
	}
	
	@Test
	public void testUpdateOne() throws SQLException {
		dao.updateOne(TodoVO.builder()
				.tno(3L)
				.title("회식이다.")
				.dueDate(LocalDate.now())
				.finished(false)
				.build());
		System.out.println("업데이트 완료");
	}
	
	@Test
	public void testDeleteOne() throws SQLException {
		dao.deleteOne(4L);
		System.out.println("삭제 완료");
	}
	
	@Test
	public void bonusTest1() throws SQLException {
		System.out.println(dao.bonus());
	}
}
