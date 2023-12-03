package com.takeo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.model.Book;
import com.takeo.service.BookService;

public class BookInventoryReadServlet  extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService bookService=new BookService();
	
		

		try {
			List<Book> listBooks=bookService.redBooks();
			RequestDispatcher rd= req.getRequestDispatcher("/bookInventory.jsp");

			req.setAttribute("books",listBooks);
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
