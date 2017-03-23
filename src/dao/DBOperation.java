package dao;

import org.hibernate.Session;

import po.Book;

public abstract class DBOperation {
	protected Session session;
	protected Object resultObject;
	public DBOperation(){}
	
	public DBOperation(Session session) {
		super();
		this.session = session;
	}
	
	public abstract boolean doExcute(Book book);
	
	
}
