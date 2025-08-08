package mylab.library.entity;

// 개별 도서의 속성과 상태 관리에 집중
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getPublishYear() {
        return this.publishYear;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    // 대출 
    public void checkOut() {
    	this.isAvailable = false;
    }

    // 반환 
    public void returnBook() {
    	this.isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format("책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %s",
        		this.title, this.author, this.isbn, this.publishYear, this.isAvailable ? "가능" : "대출 중");
    }
}