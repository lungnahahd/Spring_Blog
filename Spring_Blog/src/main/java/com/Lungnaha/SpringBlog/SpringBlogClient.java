package com.Lungnaha.SpringBlog;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringBlogClient {

	public static void main(String[] args) {
		// 1.Spring 컨테이너를 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨터이너로부터 Service 객체를 불러오기
		SpringBlogService blogService = (SpringBlogService) container.getBean("blogService");
		
		SpringBlogVO vo = new SpringBlogVO();
		
		// 3. 글 등록 기능 확인
		vo.setTitle("테스트제목");
		vo.setWriter("렁나하");
		vo.setContent("렁나하의 테스트 글....................");
		blogService.insertBlog(vo);
		
		// 4. 글 목록 조회 기능 테스트
		List<SpringBlogVO> blogList = blogService.getList(vo);
		for(SpringBlogVO blog : blogList) {
			System.out.println("------------>" + blog.toString());
		}
		
		// 5. Spring 컨테이너 사용 종료 시키기
		container.close();
		
	}

}
