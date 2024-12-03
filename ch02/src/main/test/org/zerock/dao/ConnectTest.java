package org.zerock.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectTest {
	
	@Test
	public void test1() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
		config.setUsername("aaa");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);
		
		Connection conn = ds.getConnection();
		ResultSet rs = conn.prepareStatement("select now()").executeQuery();
		rs.next();
		System.out.println(rs.getDate(1));
	}
	
	@Test
	public void test2() {
		System.out.println("Test");
	}
}
