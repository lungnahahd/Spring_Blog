package com.Lungnaha.SpringBlog;

import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;

// MyBatis ��� ���� �����ͺ��̽� ���� ó���� JDBC�� �ϱ� ���ؼ� �̿�Ǵ� Ŭ����
// �̸� ���� Connection ȹ��� ���� �۾��� �������� ó��
public class JDBCUtil {
	public static Connection getConnection{
		try {
			Class.forName("org.mysql.Driver"); // Ȯ���� �ʿ��� �κ�
			return DriverManager.getConnection(null)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
