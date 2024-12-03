package org.zerock.jdbcex.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//
public enum ConnectionUtil {
	INSTANCE;
	
	private HikariDataSource ds;
	
	private ConnectionUtil() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
		config.setUsername("aaa");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		this.ds = new HikariDataSource(config);
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}
}
