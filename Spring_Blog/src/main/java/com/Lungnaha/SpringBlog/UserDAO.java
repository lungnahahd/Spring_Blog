package com.Lungnaha.SpringBlog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 멤버 관리와 관련된 DAO 클래스
// 여기서도 역시 JDBCUtil.java를 이용해서 기능 구현하기
public class UserDAO {
	// JDBC에서 사용되는 변수들 선언
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// 사용할 SQL문 작성
	private final String userGet = "select * from springmember where id=? and password=?";
	private final String userJoin = "insert into springmember(id, password, name, role) values(?,?,?,?)";
	
	//CRUD 기능의 메소드 구현
	// 회원 등록
	public void singUp(UserVO vo) {
		try {
			System.out.println("========> 회원 가입 시작");
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
	
	// 회원 조회 기능 구현
	public UserVO findUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("==========> 회원 조회 시작");
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
