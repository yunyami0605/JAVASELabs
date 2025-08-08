package mylab.library.control;

import mylab.library.entity.Library;
import mylab.library.entity.Book;

import java.util.List;

// 클래스는 테스트와 사용자 인터페이스 역할을 담당
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));

        printLibraryStatus(library);

        System.out.println("\n 1. 도서 검색 테스트");
        Book bookByTitle = library.findByTitle("자바의 정석");
        System.out.println("제목으로 검색 결과:");
        System.out.println(bookByTitle);

        List<Book> booksByAuthor = library.findByAuthor("Robert C. Martin");
        System.out.println("\n저자로 검색 결과:");
        for (Book b : booksByAuthor) {
            System.out.println(b);
        }

        System.out.println("\n 2. 도서 대출 테스트");
        if (library.checkOutBook("978-89-01-14077-4")) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            System.out.println(library.findByISBN("978-89-01-14077-4"));
        }

        printLibraryStatus(library);

        System.out.println("\n 3. 도서 반납 테스트");
        if (library.returnBook("978-89-01-14077-4")) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            System.out.println(library.findByISBN("978-89-01-14077-4"));
        }

        printLibraryStatus(library);

        System.out.println(" 4. 대출 가능한 도서 목록");
        for (Book b : library.getAvailableBooks()) {
            System.out.println(b);
            System.out.println("------------------------");
        }
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("\n 5.중앙 도서관");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBookCount());
        System.out.println("대출 중인 도서 수: " + library.getCheckedOutBookCount());
    }
}
