package com.Lungnaha.SpringBlog;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class userClient {

	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� Service ��ü�� �̿�
		UserService service = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		
		// 3. ȸ�� ���� ��� ���
		vo.setId("lungnaha");
		vo.setPassword("1111");
		vo.setName("������");
		vo.setRole("â����");
		service.singUp(vo);
		
		// 4. ȸ�� ��ȸ ��� ���
		UserVO check = service.findUser(vo);
		
		if(check != null) {
			System.out.println(check.getName() + " �� ȯ���մϴ�. ^^");
			System.out.println(check.getRole() + " �ش� ���� �̱���!!");
		}else {
			System.out.println("�˼��մϴ�. ȸ�� Ȯ���� ���� �ʽ��ϴ�.");
		}
		
		// 5. ��� ���� ��, �����̳ʸ� ����
		container.close();
	}

}
