package com.Lungnaha.SpringBlog;

public class UserService implements UserInterface {

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
