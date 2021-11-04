package com.fastcampus.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// JDBC 1�ܰ� : ����̹� �ε�
			DriverManager.registerDriver(new org.h2.Driver());
			
			// JDBC 2�ܰ� : Connection ����(ȹ��) : Connection�� ��ӵ��δ�.
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Statement stmt, Connection conn) {
		// JDBC 5�ܰ� : Connection ����
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		// JDBC 5�ܰ� : Connection ����
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			rs = null;
		}
		
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}







