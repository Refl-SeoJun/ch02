package org.zerock.jdbcex.service;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.zerock.jdbcex.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TodoServiceTests {
	@Test
	public void testRegister() throws SQLException {
		TodoDTO dto = TodoDTO.builder()
				.title("sample Test")
				.dueDate(LocalDate.now())
				.build();
		TodoService.INSTANCE.register(dto);
		log.info("드디어 log for(4) j(java)를 사용합니다.");
	}
}
