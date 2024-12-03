package org.zerock.jdbcex.service;

import java.sql.SQLException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

//사용자 입장에서의 서비스 
public enum TodoService {
	INSTANCE;
	
	private TodoDAO dao;
	TodoService(){
		dao = new TodoDAO();
	}
	
	//1.할일목록
	//2.할일조회
	//3.할일작성
	public void register(TodoDTO dto) throws SQLException {
		//DTO->VO
//		TodoVO vo = TodoVO.builder()
//		.tno(dto.getTno())
//		.title(dto.getTitle())
//		.dueDate(dto.getDueDate())
//		.finished(dto.isFinished())
//		.build();
//		
//		//modelMapper 사용법
		ModelMapper mapper = MapperUtil.INSTANCE.getMapper();
		dao.insert(mapper.map(dto, TodoVO.class));
	}
	//4.할일수정
	//5.할일삭제
}
