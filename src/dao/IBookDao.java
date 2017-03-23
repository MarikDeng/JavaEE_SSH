package dao;

import po.Book;

public interface IBookDao {
	public boolean insert(Book book);
	public boolean delete(Book book);
	public boolean update(Book book);
	public boolean query(Book book);
}
