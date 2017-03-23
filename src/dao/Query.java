package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Book;

public class Query extends DBOperation{
	
	//private Session session;
	
	
	
	public Object getResultObject() {
		return resultObject;
	}

	public Query(){};

	public Query(Session session) {
		super(session);
		//this.session = session;
	}
	
	public void doExcute(Session session){
		
		Book book = (Book) session.get(Book.class, "B10001");//要按照po的student属性的数据类型来传值
		System.out.println(book.getBookId());
		System.out.println(book.getBookName());
		System.out.println(book.getBookNum());
	}
	
	public void doExcute(){
		Book book = (Book) session.get(Book.class, "B10001");//要按照po的student属性的数据类型来传值
		System.out.println(book.getBookId());
		System.out.println(book.getBookName());
		System.out.println(book.getBookNum());
	}
	
	/*public void doExcute(Class c, String searchString){
		Book book = (Book) session.get(c, "B10001");//要按照po的student属性的数据类型来传值
		System.out.println(book.getBookId());
		System.out.println(book.getBookName());
		System.out.println(book.getBookNum());
	}*/
	
	
	@SuppressWarnings("finally")
	public boolean doExcute(Book book){
		
		boolean flag = false;
		try {
			resultObject = session.get(book.getClass(), book.getBookId());
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		finally{
			//session.close();
			return flag;
		}
	}
	
}
