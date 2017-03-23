package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.PUBLIC_MEMBER;

import po.Book;
import po.Student;

public class Update extends DBOperation{

	public Update(Session session) {
		super(session);
	}

	@SuppressWarnings("finally")
	public boolean doExcute(Book object){
		boolean flag = false;
		try {
			//object.setBookName("updateName");
			Book book = (Book) session.get(object.getClass(), object.getBookId());
			if(object.getBookName()!=null){
				book.setBookName(object.getBookName());
			}
			if(object.getBookNum()!=-1){
				book.setBookNum(object.getBookNum());
			}
			if(object.getBookPrice()!=-1){
				book.setBookPrice(object.getBookPrice());
			}
			Transaction transaction = session.beginTransaction();
			session.update(book);
			//session.update(object);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			flag = false;
		}
		finally{
			//session.close();
			return flag;
		}
	}

}
