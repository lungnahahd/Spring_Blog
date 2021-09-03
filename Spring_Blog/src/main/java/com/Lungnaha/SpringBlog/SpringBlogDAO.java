package com.Lungnaha.SpringBlog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import java.sql.Connection;

// VO 클래스를 이용해서 CRUD 기능을 수행할 저장소 역할을 하는 클래스
@Repository("blogDAO")
public class SpringBlogDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// 처리할 SQL 명령어들 
	private final String insertString = "insert into springblog(id, title, writer, content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateString = "update springblog set title=?, content=? where id=? ";
	private final String deleteString = "delete springblog where id=?";
	private final String getString ="select * from springblog where id=?";
	private final String listString = "select * from springblog order by id desc";
	
	// CRUD 기능을 수행하는 메소드 구현
	// 글 등록 메소드
	public void insertBlog(SpringBlogVO vo) {
		System.out.println("===>글 등록 시작");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(insertString);
			// 글 등록을 위해서 VO 클래스에서 정보를 받아오는 부분
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
