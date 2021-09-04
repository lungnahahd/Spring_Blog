package com.Lungnaha.SpringBlog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// ��� ������ ���õ� DAO Ŭ����
// ���⼭�� ���� JDBCUtil.java�� �̿��ؼ� ��� �����ϱ�
public class UserDAO {
	// JDBC���� ���Ǵ� ������ ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// ����� SQL�� �ۼ�
	private final String userGet = "select * from springmember where id=? and password=?";
	private final String userJoin = "insert into springmember(id, password, name, role) values(?,?,?,?)";
	
	//CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	public void singUp(UserVO vo) {
		try {
			System.out.println("========> ȸ�� ���� ����");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(userJoin);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// ȸ�� ��ȸ ��� ����
	public UserVO findUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("==========> ȸ�� ��ȸ ����");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(userGet);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt,conn);
		}
		return user;
	}
	
}
