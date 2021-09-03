package com.Lungnaha.SpringBlog;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringBlogClient {

	public static void main(String[] args) {
		// 1.Spring �����̳ʸ� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� Service ��ü�� �ҷ�����
		SpringBlogService blogService = (SpringBlogService) container.getBean("blogService");
		
		SpringBlogVO vo = new SpringBlogVO();
		
		// 3. �� ��� ��� Ȯ��
		vo.setTitle("�׽�Ʈ����");
		vo.setWriter("������");
		vo.setContent("�������� �׽�Ʈ ��....................");
		blogService.insertBlog(vo);
		
		// 4. �� ��� ��ȸ ��� �׽�Ʈ
		List<SpringBlogVO> blogList = blogService.getList(vo);
		for(SpringBlogVO blog : blogList) {
			System.out.println("------------>" + blog.toString());
		}
		
		// 5. Spring �����̳� ��� ���� ��Ű��
		container.close();
		
	}

}
