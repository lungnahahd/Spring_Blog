package com.Lungnaha.SpringBlog;

import java.sql.DriverManager;

import org.apache.catalina.startup.FailedContext;

import com.sun.jdi.connect.spi.Connection;

public class JDBCTest {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springprac?serverTimezone=Asia/Seoul","root","khd10810")){
			System.out.println(connection);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
