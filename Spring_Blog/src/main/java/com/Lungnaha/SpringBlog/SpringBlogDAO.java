package com.Lungnaha.SpringBlog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.sun.jdi.connect.spi.Connection;

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
}
