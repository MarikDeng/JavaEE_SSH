package actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import po.Book;

import com.opensymphony.xwork2.ActionSupport;

import dao.DBOperation;
import dao.Insert;
import dao.Query;
import dao.Update;

public class BookAction extends ActionSupport {
	private static ApplicationContext aContext = WebApplicationContextUtils.getRequiredWebApplicationContext( ServletActionContext.getServletContext());
	private String bookName;
	private String bookId;
	private float bookPrice = -1;
	private int bookNum = -1;
	private Book book;
	
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
	
	public String doQuery(){
		HttpServletRequest request =ServletActionContext.getRequest();
		DBOperation query = (DBOperation) aContext.getBean("bookQuery");
		
		if(query.doExcute(new Book(bookName, bookId, bookPrice, bookNum))){
			request.setAttribute("book", ((Query)query).getResultObject());
			return "success";
			
		}
		return "fail";
	}
	
	public String doUpdate(){
		DBOperation update = (DBOperation) aContext.getBean("bookUpdate");
		
		if(update.doExcute(new Book(bookName, bookId, bookPrice, bookNum))){
			return "success";
		}
		
		return "fail";
	}
	
	public String doDelete(){
		return "delete";
	}
	
	public String doInsert(){
		DBOperation insert = (DBOperation) aContext.getBean("bookInsert");
		if(insert.doExcute(new Book(bookName, bookId, bookPrice, bookNum))){
			return "success";
		}
		
		return "fail";
	}
	
}
