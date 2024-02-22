package edu.kh.jsp.model.dto;

public class Book {

	// 필드 (== 멤버 변수)
	private String title;
	private String writer;
	private int price;
	
	// 기본 생성자
	public Book() {}

	// 매개 변수 생성자
	public Book(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
	
	
	
}
