package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Book;

public class BookDao implements IBookDao {
	
	private Session hibernateSession;
	private Book queryBook;

	public Session getHibernateSession() {
		return hibernateSession;
	}

	public void setHibernateSession(Session hibernateSession) {
		this.hibernateSession = hibernateSession;
	}


	@SuppressWarnings("finally")
	@Override
	public boolean insert(Book book) {
		boolean flag = false;
		try {
			Transaction tran = hibernateSession.beginTransaction();
			hibernateSession.saveOrUpdate(book);
			tran.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exce ption
			flag = false;
		}
		finally{
			//hibernateSession.close();
			return flag;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean delete(Book book) {
		boolean flag = false;
		try {
			Object object = (Object) hibernateSession.get(book.getBookId(), book.getBookId());
			Transaction tran = hibernateSession.beginTransaction();
			hibernateSession.delete(object);
			tran.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		finally{
			//hibernateSession.close();
			return flag;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Book book) {
		boolean flag = false;
		try {
			//object.setBookName("updateName");
			Book book2 = (Book) hibernateSession.get(book.getClass(), book.getBookId());
			if(book.getBookName()!=null){
				book2.setBookName(book.getBookName());
			}
			if(book.getBookNum()!=-1){
				book2.setBookNum(book.getBookNum());
			}
			if(book.getBookPrice()!=-1){
				book2.setBookPrice(book.getBookPrice());
			}
			Transaction transaction = hibernateSession.beginTransaction();
			hibernateSession.update(book2);
			//hibernateSession.update(object);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			flag = false;
		}
		finally{
			//hibernateSession.close();
			return flag;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean query(Book book) {
		
		boolean flag = false;
		try {
			queryBook = (Book) hibernateSession.get(book.getClass(), book.getBookId());
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		finally{
			//hibernateSession.close();
			return flag;
		}
	}

}
