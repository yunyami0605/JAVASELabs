package mylab.publish.entity;


/*
 * Publication을 상속받아 참고서 정보를 표현합니다.
field(분야) 속성을 추가로 가집니다.
toString()을 오버라이드하여 참고서 정보를 상세히 표시합니다.
주요 속성:
field: 전문 분야 (예: "컴퓨터언어학습")
 * */

public class ReferenceBook extends Publication {
	private String field;

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("%s [참고서] 분야:%s, %d쪽, %d원, 출판일:%s",
                getTitle(), this.field, getPage(), getPrice(), getPublishDate());
    }
}
