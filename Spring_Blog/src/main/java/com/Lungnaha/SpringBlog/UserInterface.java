package com.Lungnaha.SpringBlog;

public interface UserInterface {

	//CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	void singUp(UserVO vo);

	// ȸ�� ��ȸ ��� ����
	UserVO findUser(UserVO vo);

}