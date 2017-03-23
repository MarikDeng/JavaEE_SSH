package po;

public class Book {
	
	private String bookName;
	private String bookId;
	private float bookPrice;
	private int bookNum;
	
	public Book(){};//使用Hibernate一定要有无参constructor
	
	public Book(String bookName, String bookId, float bookPrice, int bookNum) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		this.bookPrice = bookPrice;
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

}
