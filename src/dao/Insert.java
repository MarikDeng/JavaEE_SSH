package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.Book;
import po.Student;

public class Insert extends DBOperation {
	
	//private Session session;

	public Insert(Session session) {
		super(session);
		//this.session = session;
	}

	
	
	@SuppressWarnings("finally")
	public boolean doExcute(Book object){
		boolean flag = false;
		try {
			Transaction tran = session.beginTransaction();
			session.saveOrUpdate(object);
			tran.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exce ption
			flag = false;
		}
		finally{
			//session.close();
			return flag;
		}
	}

}
