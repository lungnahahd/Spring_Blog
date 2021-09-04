package com.Lungnaha.SpringBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserInterface {

	@Autowired
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
