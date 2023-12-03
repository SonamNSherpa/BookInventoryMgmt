package com.takeo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.takeo.model.Book;
import com.takeo.util.DBConnection;

public class BookDao {

	public void addBook(Book book) {
		PreparedStatement ps = null;
		Connection con = null;
		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT MAX(BOOK_ID) FROM bookinventory");
			ResultSet rs = ps.executeQuery();
			int maxId = 0;
			while (rs.next()) {
				maxId = rs.getInt(1);
			}

			ps = con.prepareStatement("insert into bookinventory(Book_Id, Book_Name, Book_Category, Book_Price, Book_Description, Book_Author) values" + "(?,?,?,?,?,?)");// Insert
																													
			ps.setInt(1, ++maxId);
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getCategory());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getBookDescription());
			ps.setString(6, book.getAuthor());
			
			

			ps.execute();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Book> readBooks() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		con = DBConnection.getConnection();
		ps = con.prepareStatement("SELECT * FROM bookinventory");
		ResultSet rs = ps.executeQuery();
		List<Book> listBooks = new ArrayList();
		
		while (rs.next()) {
			
			
			Book book = new Book();
			
			int id = rs.getInt(1);
			String bookname = rs.getString(2);
			String category = rs.getString(3);
			Double price = rs.getDouble(4);
			String description = rs.getString(5);
			String author = rs.getString(6);
			book.setBookId(id);
			book.setBookName(bookname);
			book.setCategory(category);
			book.setPrice(price);
			book.setBookDescription(description);
			book.setAuthor(author);
			
			listBooks.add(book);

		}

		return listBooks;
	}
	
	public void updateBook(Book book) {
		PreparedStatement ps = null;
		Connection con = null;
		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT MAX(BOOK_ID) FROM bookinventory");
			ResultSet rs = ps.executeQuery();
			int maxId = 0;
			while (rs.next()) {
				maxId = rs.getInt(1);
			}

			ps = con.prepareStatement("UPDATE bookinventory SET Book_Id=?, Book_Name=?, Book_Category=?, Book_Price=?, Book_Description=?, Book_Author=? WHERE BOOK_ID=?"); 
																													
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getCategory());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getBookDescription());
			ps.setString(6, book.getAuthor());
			ps.setInt(7, book.getBookId());
			
			

			ps.execute();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteBook(int id) {
		PreparedStatement ps = null;
		Connection con = null;
		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT MAX(BOOK_ID) FROM bookinventory");
			ResultSet rs = ps.executeQuery();
			int maxId = 0;
			while (rs.next()) {
				maxId = rs.getInt(1);
			}

			ps = con.prepareStatement("DELETE FROM bookinventory WHERE Book_Id=?");// Insert
																													
			ps.setInt(1, id);
	
			
			

			ps.execute();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
