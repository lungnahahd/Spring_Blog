package com.Lungnaha.SpringBlog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import java.sql.Connection;

// VO Ŭ������ �̿��ؼ� CRUD ����� ������ ����� ������ �ϴ� Ŭ����
@Repository("blogDAO")
public class SpringBlogDAO {
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// ó���� SQL ��ɾ�� 
	private final String insertString = "insert into springblog(id, title, writer, content) values((select nvl(max(id),0)+1 from board),?,?,?)";
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
}
