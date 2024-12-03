package org.zerock.jdbcex.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import lombok.extern.log4j.Log4j2;

//사용자 입장에서의 서비스
@Log4j2
public enum TodoService {
	INSTANCE;
	
	private TodoDAO dao;
	TodoService(){
		dao = new TodoDAO();
	}
	
	//1.할일목록

	public List<TodoDTO> listAll() throws SQLException{
		log.info("서비스 할일 목록 요청");
		List<TodoVO> voList = dao.selectAll();
		ModelMapper mapper = MapperUtil.INSTANCE.getMapper();
		List<TodoDTO> dtoList = new ArrayList<>();
		//변환 List<TodoVO> -> List<TodoDTO>
		//변환시키시오. 람다식x, 스트림APIx
		for(TodoVO item:voList) {
			TodoDTO dto = mapper.map(item, TodoDTO.class);
			dtoList.add(dto);
		}
		
		List<TodoDTO> dtoList2 = voList.stream()
		.map(x->mapper.map(x, TodoDTO.class))
		.collect(Collectors.toList());
		
		return dtoList;
	}
	//2.할일조회
	public TodoDTO get(long tno) throws SQLException {
		log.info("할일 조회 요청");
		TodoVO vo = dao.selectOne(tno);
		ModelMapper mapper = MapperUtil.INSTANCE.getMapper();
		TodoDTO dto = mapper.map(vo, TodoDTO.class);
		return dto;
	}
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
		log.info("할일작성 서비스 요청"+dto);
		ModelMapper mapper = MapperUtil.INSTANCE.getMapper();
		dao.insert(mapper.map(dto, TodoVO.class));
	}
	//4.할일수정
	public void update(TodoDTO dto) throws SQLException {
		log.info("할일 수정 요청");
		
		ModelMapper mapper = MapperUtil.INSTANCE.getMapper();
		dao.updateOne(mapper.map(dto, TodoVO.class));
	}
	//5.할일삭제
	public void delete(long tno) throws SQLException {
		log.info("할일 삭제 요청");
		dao.deleteOne(tno);
	}
}
