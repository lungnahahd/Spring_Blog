package com.Lungnaha.SpringBlog;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class userClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨터이너로부터 Service 객체를 이용
		UserService service = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		
		// 3. 회원 가입 기능 사용
		vo.setId("lungnaha");
		vo.setPassword("1111");
		vo.setName("렁나하");
		vo.setRole("창조자");
		service.singUp(vo);
		
		// 4. 회원 조회 기능 사용
		UserVO check = service.findUser(vo);
		
		if(check != null) {
			System.out.println(check.getName() + " 님 환영합니다. ^^");
			System.out.println(check.getRole() + " 해당 역할 이군요!!");
		}else {
			System.out.println("죄송합니다. 회원 확인이 되지 않습니다.");
		}
		
		// 5. 사용 종료 후, 컨테이너를 종료
		container.close();
	}

}
