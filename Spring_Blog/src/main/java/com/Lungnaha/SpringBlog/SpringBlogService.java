package com.Lungnaha.SpringBlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 인터페이스를 이용해서 서비스를 구현하는 클래스
@Service("blogService")
public class SpringBlogService implements SpringBlogInterfaceService {

	// Service에서 이용하기 위해 DAO 클래스를 연결
	// 즉 사용자들이 Service를 통해서 접근하면 Service에서는 DAO에 구현된 기능을 통해서 DB 접근하서 적절한 동작 수행 가능
	// 정리하면, DAO는 JDBC를 이용해서 DB와 연동이 되고, Service는 DAO를 통해서 DB를 이용할 수 있는 것!
	@Autowired
	private SpringBlogDAO blogDAO;
	
	@Override
	public void insertBlog(SpringBlogVO vo) {
		blogDAO.insertBlog(vo);
	}

	@Override
	public void updateBlog(SpringBlogVO vo) {
		blogDAO.updateBlog(vo);
	}

	@Override
	public void deleteBlog(SpringBlogVO vo) {
		blogDAO.deleteBlog(vo);
	}

	@Override
	public SpringBlogVO getBlog(SpringBlogVO vo) {
		return blogDAO.getBlog(vo);
	}

	@Override
	public List<SpringBlogVO> getList(SpringBlogVO vo) {
		return blogDAO.getList(vo);
	}
}
