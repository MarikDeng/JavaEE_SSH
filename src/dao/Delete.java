package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.Book;
import po.Student;

public class Delete extends DBOperation{

	//private Session session;

	public Delete(Session session) {
		super(session);
		//this.session = session;
	}

	public void doExcute(String bookId) {
		Book book = (Book) session.get(Student.class, bookId);
		if (book.getBookId().equals(bookId)) {
			Transaction tran = session.beginTransaction();
			session.delete(book);
			tran.commit();
		}
		session.close();
	}
	
	@SuppressWarnings("finally")
	public boolean doExcute(Book book) {
		boolean flag = false;
		try {
			Object object = (Object) session.get(book.getBookId(), book.getBookId());
			Transaction tran = session.beginTransaction();
			session.delete(object);
			tran.commit();
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
