package org.zerock.jdbcex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.zerock.jdbcex.domain.TodoVO;

import lombok.Cleanup;

public class TodoDAO {
	
	//1.할일쓰기
	public void insert(TodoVO vo) throws SQLException {
		String sql = "insert into tbl_todo(title, dueDate) values(?,?)";
		//1.커넥션 가져오기
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		//2.쿼리 작성
		pstmt.setString(1, vo.getTitle());
		pstmt.setDate(2, java.sql.Date.valueOf(vo.getDueDate()));
		pstmt.executeUpdate();
	}
	//2.할일목록보기
	public List<TodoVO> selectAll() throws SQLException{
		String sql = "select * from tbl_todo";
		//1.커넥션 가져오기
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		//2.쿼리 작업
		@Cleanup ResultSet rs = pstmt.executeQuery();
		//3.결과를 리턴형태로 변환
		List<TodoVO> list = new ArrayList<>();
		while(rs.next()) {
			TodoVO vo = TodoVO.builder()
					.tno(rs.getLong("tno"))
					.title(rs.getString("title"))
					.dueDate(rs.getDate("dueDate").toLocalDate())
					.finished(rs.getBoolean("finished"))
					.build();
			list.add(vo);
		}
		return list;
	}
	//3.할일조회
	public TodoVO selectOne(Long tno) throws SQLException {
		String sql = "select * from tbl_todo where tno=?";
		//1.커넥션 가져오기
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		//2.쿼리 작업
		pstmt.setLong(1, tno);
		@Cleanup ResultSet rs = pstmt.executeQuery();
		rs.next();
		TodoVO vo = TodoVO.builder()
				.tno(rs.getLong("tno"))
				.title(rs.getString("title"))
				.dueDate(rs.getDate("dueDate").toLocalDate())
				.finished(rs.getBoolean("finished"))
				.build();
		return vo;
	}
	//4.수정하기
	public void updateOne(TodoVO vo) throws SQLException {
		String sql = "update tbl_todo set title=?, dueDate=?, finished=? where tno=?";
		//1.커넥션 가져오기
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		//2.쿼리 작성
		pstmt.setString(1, vo.getTitle());
		pstmt.setDate(2, java.sql.Date.valueOf(vo.getDueDate()));
		pstmt.setBoolean(3, vo.isFinished());
		pstmt.setLong(4, vo.getTno());
		pstmt.executeUpdate();
	}
	//5.삭제하기
	public void deleteOne(Long tno) throws SQLException {
		String sql = "delete from tbl_todo where tno=?";
		//1.커넥션 가져오기
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		//2.쿼리 작성
		pstmt.setLong(1, tno);
		pstmt.executeUpdate();
	}
	//6.보너스 (오늘의 미완료 할일 개수)
	public int bonus() throws SQLException {
		String sql = "select count(*) from tbl_todo where finished=?";
		//1.커넥션 가져오기
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		//2.쿼리 작업
		pstmt.setBoolean(1, false);
		@Cleanup ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		return count;
	}
	
	
	public Date getTime() throws SQLException{
		Connection conn = ConnectionUtil.INSTANCE.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select now()");
		ResultSet rs = pstmt.executeQuery();
		
		Date testDate = null;
		try(conn; pstmt; rs;) {
			rs.next();
			testDate = rs.getDate(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDate;
	}
}
