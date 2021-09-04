package com.Lungnaha.SpringBlog;

public class UserService implements UserInterface {

	private UserDAO userDAO;
	
	
	// 회원 가입 서비스
	@Override
	public void singUp(UserVO vo) {
		userDAO.singUp(vo);
	}

	// 회원 조회 서비스
	@Override
	public UserVO findUser(UserVO vo) {
		return userDAO.findUser(vo);
	}

}
