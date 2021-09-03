package com.Lungnaha.SpringBlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// �������̽��� �̿��ؼ� ���񽺸� �����ϴ� Ŭ����
@Service("blogService")
public class SpringBlogService implements SpringBlogInterfaceService {

	// Service���� �̿��ϱ� ���� DAO Ŭ������ ����
	// �� ����ڵ��� Service�� ���ؼ� �����ϸ� Service������ DAO�� ������ ����� ���ؼ� DB �����ϼ� ������ ���� ���� ����
	// �����ϸ�, DAO�� JDBC�� �̿��ؼ� DB�� ������ �ǰ�, Service�� DAO�� ���ؼ� DB�� �̿��� �� �ִ� ��!
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
