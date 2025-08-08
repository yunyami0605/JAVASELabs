package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

// 도서 컬렉션 관리와 검색, 대출/반납 기능을 제공 
public class Library {
	// 도서 목록 필드
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(Book book) {
    	this.books.add(book);
        System.out.println("도서가 추가되었습니다:" + book.getTitle());
    }

    // 제목 검사
    public Book findByTitle(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book findByISBN(String isbn) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    //도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = this.findByISBN(isbn);
        if (book != null && book.getIsAvailable()) {
            book.checkOut();
            return true;
        }
        return false;
    }

    //도서 반납
    public boolean returnBook(String isbn) {
        Book book = this.findByISBN(isbn);
        if (book != null && !book.getIsAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    //대출 가능한 도서 목록
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getIsAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    // 모든 도서 목록
    public List<Book> getAllBooks() {
        return this.books;
    }

    public int getTotalBooks() {
        return this.books.size();
    }

    public int getAvailableBookCount() {
        return this.getAvailableBooks().size();
    }

    public int getCheckedOutBookCount() {
        return this.getTotalBooks() - this.getAvailableBookCount();
    }
}