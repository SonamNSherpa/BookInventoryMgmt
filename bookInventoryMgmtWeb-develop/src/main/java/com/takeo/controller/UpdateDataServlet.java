package com.takeo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.model.Book;
import com.takeo.service.BookService;

public class UpdateDataServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String first ="update";
	String second ="delete";
	int id = Integer.parseInt(req.getParameter("bId"));
	String bName=	req.getParameter("bName");
	String category = req.getParameter("category");
	String price=	req.getParameter("price");
	String description = req.getParameter("description");
	String author = req.getParameter("author");
	
	String action= req.getParameter("action");
	
	if(first.equals(action)) {
		BookService bookService=new BookService();
		try {
		Book book=new Book();
		book.setBookId(id);
		book.setBookName(bName);
		book.setCategory(category);
		book.setPrice(Double.parseDouble(price));
		book.setBookDescription(description);
		book.setAuthor(author);

		bookService.updateBook(book);

		RequestDispatcher rd= req.getRequestDispatcher("/bookInventory.jsp");

		req.setAttribute("insertRes", "success");
		rd.forward(req, resp);
		}catch (NumberFormatException e) {
			RequestDispatcher rd= req.getRequestDispatcher("/bookInventory.jsp");

			req.setAttribute("insertRes", "there is an issue in your requet pls corret it");
			rd.forward(req, resp);
		}

	}
	else if(second.equals(action)){
		BookService bookService=new BookService();
		try {
		
		
		bookService.deleteBook(id);

		RequestDispatcher rd= req.getRequestDispatcher("/bookInventory.jsp");

		req.setAttribute("insertRes", "success");
		rd.forward(req, resp);
		}catch (NumberFormatException e) {
			RequestDispatcher rd= req.getRequestDispatcher("/bookInventory.jsp");

			req.setAttribute("insertRes", "there is an issue in your requet pls corret it");
			rd.forward(req, resp);
		}
	}

		
		
	}

}
