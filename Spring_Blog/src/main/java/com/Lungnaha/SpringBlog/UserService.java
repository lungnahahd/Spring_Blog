package com.Lungnaha.SpringBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserInterface {

	@Autowired
	private UserDAO userDAO;
	
	
	// ȸ�� ���� ����
	@Override
	public void singUp(UserVO vo) {
		userDAO.singUp(vo);
	}

	// ȸ�� ��ȸ ����
	@Override
	public UserVO findUser(UserVO vo) {
		return userDAO.findUser(vo);
	}

}
