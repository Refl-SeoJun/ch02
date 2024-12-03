package org.zerock.jdbcex.dto;

import java.time.LocalDate;

import org.zerock.jdbcex.domain.TodoVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//VO객체 대비 기본생성자와 setter가 있다.
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDTO {

	private Long tno;
	private String title;
	private LocalDate dueDate;
	private boolean finished;

}
