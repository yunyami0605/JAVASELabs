package workshop.book.entity;

public class ReferenceBook extends Publication {
	private String field;
	
	public ReferenceBook() {}

	public ReferenceBook(String title, String publishingDate, int page, int price, String field) {
		super(title, publishingDate, page, price);
		this.field = field;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	@Override
	public String toString() {
		return "REF BOOK";
	}
}