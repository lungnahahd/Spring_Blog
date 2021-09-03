package com.Lungnaha.SpringBlog;

import java.util.List;

public interface SpringBlogInterfaceService {

	// �� ��� �޼ҵ�
	void insertBlog(SpringBlogVO vo);

	// �� ���� ��� �޼ҵ�
	void updateBlog(SpringBlogVO vo);

	// �� ���� ��� �޼ҵ�
	void deleteBlog(SpringBlogVO vo);

	// �� �� ��ȸ �޼ҵ�
	SpringBlogVO getBlog(SpringBlogVO vo);

	// �� ��� ��ȸ �޼ҵ�
	List<SpringBlogVO> getList(SpringBlogVO vo);

}