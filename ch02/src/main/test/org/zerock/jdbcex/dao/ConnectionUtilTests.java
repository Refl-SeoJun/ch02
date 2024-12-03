package org.zerock.jdbcex.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionUtilTests {
	
	@Test
	public void testGetConnection() throws SQLException {
		
		System.out.println(ConnectionUtil.INSTANCE.getConnection());
		
		Connection conn = ConnectionUtil.INSTANCE.getConnection();
		assertNotNull(conn);
		
	}

}
