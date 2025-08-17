package mylab.publish.entity;


/*
 * 모든 출판물의 기본 클래스로 title, publishDate, page, price 속성을 가집니다.
기본 생성자와 모든 멤버변수를 초기화하는 생성자를 제공합니다.
toString() 메서드는 요구사항에 맞게 title만 반환합니다.
주요 속성:
title: 출판물 제목
publishDate: 출간일 (yyyy-MM-dd 형식)
page: 페이지 수
price: 가격
// 기본 생성자: 빈 객체 생성 

 * */

public class Publication {

	private String title;
	private String publishDate;
	private int page;
	private int price;
	
	public Publication() {}
	public Publication(String title, String publishDate, int page, int price) {
		this.title = title;
		this.publishDate = publishDate;
		this.page = page;
		this.price = price;
	}
	
	public String getTitle() {
        return this.title;
    }
	
	public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return this.publishDate;
    }
    
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    
    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return this.page;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

	
    @Override
    public String toString() {
        return this.title;
    }
}
