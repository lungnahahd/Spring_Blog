package com.Lungnaha.SpringBlog;

import java.util.List;

public interface SpringBlogInterfaceService {

	// 글 등록 메소드
	void insertBlog(SpringBlogVO vo);

	// 글 수정 기능 메소드
	void updateBlog(SpringBlogVO vo);

	// 글 삭젝 기능 메소드
	void deleteBlog(SpringBlogVO vo);

	// 글 상세 조회 메소드
	SpringBlogVO getBlog(SpringBlogVO vo);

	// 글 목록 조회 메소드
	List<SpringBlogVO> getList(SpringBlogVO vo);

}