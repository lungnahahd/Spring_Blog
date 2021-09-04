package com.Lungnaha.SpringBlog;

public interface UserInterface {

	//CRUD 기능의 메소드 구현
	// 회원 등록
	void singUp(UserVO vo);

	// 회원 조회 기능 구현
	UserVO findUser(UserVO vo);

}