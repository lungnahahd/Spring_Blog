package com.Lungnaha.SpringBlog;

import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;

// MyBatis 사용 전에 데이터베이스 연동 처리를 JDBC로 하기 위해서 이용되는 클래스
// 이를 통해 Connection 획득과 해제 작업을 공통으로 처리
public class JDBCUtil {
	public static Connection getConnection{
		try {
			Class.forName("org.mysql.Driver"); // 확인이 필요한 부분
			return DriverManager.getConnection(null)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
