package com.Lungnaha.SpringBlog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.sql.Connection;

// VO 클래스를 이용해서 CRUD 기능을 수행할 저장소 역할을 하는 클래스
@Repository("blogDAO")
public class SpringBlogDAO  {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// 처리할 SQL 명령어들 
	private final String insertString = "insert into springblog(title, writer, content) values(?,?,?)";
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
	
	// 글 수정 기능 메소드
	public void updateBlog(SpringBlogVO vo) {
		System.out.println("=====> 글 수정 시작");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(updateString);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 삭젝 기능 메소드
	public void deleteBlog(SpringBlogVO vo) {
		System.out.println("=====> 글 삭제 시작");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteString);
			stmt.setInt(1, vo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 상세 조회 메소드
	public SpringBlogVO getBlog(SpringBlogVO vo) {
		System.out.println("=========>글 상세 조회 시작");
		SpringBlogVO blog = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getString);
			// 쿼리문의 결과를 받는 부분 
			stmt.setInt(1, vo.getId());
			rs = stmt.executeQuery();
			// 결과를 VO 객체의 값으로 저장하는 부분
			if(rs.next()) {
				blog = new SpringBlogVO();
				blog.setId(rs.getInt("ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setWriter(rs.getString("WRITER"));
				blog.setContent(rs.getString("CONTENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt,conn);
		}
		return blog;
	}
	
	// 글 목록 조회 메소드
	public List<SpringBlogVO> getList(SpringBlogVO vo){
		System.out.println("=====>글 목록 조회 시작");
		List<SpringBlogVO> blogList = new ArrayList<SpringBlogVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listString);
			rs = stmt.executeQuery();
			while(rs.next()) {
				SpringBlogVO blog = new SpringBlogVO();
				blog.setId(rs.getInt("ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setWriter(rs.getString("WRITER"));
				blog.setContent(rs.getString("CONTENT"));
				blogList.add(blog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt,conn);
		}
		return blogList;
		
	}
}
