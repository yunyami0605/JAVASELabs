package mylab.publish.entity;

/*
 * Publication을 상속받아 소설 정보를 표현합니다.
author(저자)와 genre(장르) 속성을 추가로 가집니다.
toString()을 오버라이드하여 소설 정보를 상세히 표시합니다.
	주요 속성:
author: 저자명
genre: 장르 (예: "판타지", "로맨스")

 * */
public class Novel extends Publication{
	private String author;
	private String genre;
	
	public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }
	
	
	@Override
    public String toString() {
        return String.format("%s [소설] 저자:%s, 장르:%s, %d쪽, %d원, 출판일:%s",
                getTitle(), this.author, this.genre, getPage(), getPrice(), getPublishDate());
    }
}
