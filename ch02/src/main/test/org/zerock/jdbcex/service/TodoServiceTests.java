package org.zerock.jdbcex.service;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.zerock.jdbcex.dto.TodoDTO;

public class TodoServiceTests {
	@Test
	public void testRegister() throws SQLException {
		TodoDTO dto = TodoDTO.builder()
				.title("sample Test")
				.dueDate(LocalDate.now())
				.build();
		TodoService.INSTANCE.register(dto);
		System.out.println("등록 완료");
	}
}
