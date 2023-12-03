package com.takeo.service;

import java.sql.SQLException;
import java.util.List;

import com.takeo.dao.BookDao;
import com.takeo.model.Book;

public class BookService {
	
	BookDao bookDao;
 
	public BookService() {
		bookDao=new BookDao();
	}
	
	public void addBook(Book book) {
		bookDao.addBook(book);
	}
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}
	public void deleteBook(int i) {
		bookDao.deleteBook(i);
	}
	
	public List<Book> redBooks() throws ClassNotFoundException, SQLException{
		
		return bookDao.readBooks();
	}
}
