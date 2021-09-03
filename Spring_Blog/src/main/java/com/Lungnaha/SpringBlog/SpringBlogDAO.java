package com.Lungnaha.SpringBlog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.sql.Connection;

// VO Ŭ������ �̿��ؼ� CRUD ����� ������ ����� ������ �ϴ� Ŭ����
@Repository("blogDAO")
public class SpringBlogDAO  {
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// ó���� SQL ��ɾ�� 
	private final String insertString = "insert into springblog(title, writer, content) values(?,?,?)";
	private final String updateString = "update springblog set title=?, content=? where id=? ";
	private final String deleteString = "delete springblog where id=?";
	private final String getString ="select * from springblog where id=?";
	private final String listString = "select * from springblog order by id desc";
	
	// CRUD ����� �����ϴ� �޼ҵ� ����
	
	// �� ��� �޼ҵ�
	public void insertBlog(SpringBlogVO vo) {
		System.out.println("===>�� ��� ����");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(insertString);
			// �� ����� ���ؼ� VO Ŭ�������� ������ �޾ƿ��� �κ�
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
	
	// �� ���� ��� �޼ҵ�
	public void updateBlog(SpringBlogVO vo) {
		System.out.println("=====> �� ���� ����");
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
	
	// �� ���� ��� �޼ҵ�
	public void deleteBlog(SpringBlogVO vo) {
		System.out.println("=====> �� ���� ����");
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
	
	// �� �� ��ȸ �޼ҵ�
	public SpringBlogVO getBlog(SpringBlogVO vo) {
		System.out.println("=========>�� �� ��ȸ ����");
		SpringBlogVO blog = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getString);
			// �������� ����� �޴� �κ� 
			stmt.setInt(1, vo.getId());
			rs = stmt.executeQuery();
			// ����� VO ��ü�� ������ �����ϴ� �κ�
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
	
	// �� ��� ��ȸ �޼ҵ�
	public List<SpringBlogVO> getList(SpringBlogVO vo){
		System.out.println("=====>�� ��� ��ȸ ����");
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
