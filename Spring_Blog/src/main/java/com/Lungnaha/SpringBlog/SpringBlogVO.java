package com.Lungnaha.SpringBlog;

// VO(Value Object) 클래스를 생성 -> 데이터를 한번에 주고 받을 목적으로 사용되는 클래스
public class SpringBlogVO {
	private int id;
	private String title;
	private String writer;
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
