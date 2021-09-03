package com.Lungnaha.SpringBlog;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.jdi.connect.spi.Connection;

// MyBatis 사용 전에 데이터베이스 연동 처리를 JDBC로 하기 위해서 이용되는 클래스
// 이를 통해 Connection 획득과 해제 작업을 공통으로 처리
public class JDBCUtil {
	public static void getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs!= null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs= null;
			}
		}
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
}
