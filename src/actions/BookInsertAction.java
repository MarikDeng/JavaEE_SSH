package actions;

import po.Book;

import com.opensymphony.xwork2.ActionSupport;

public class BookInsertAction extends ActionSupport {
	
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
