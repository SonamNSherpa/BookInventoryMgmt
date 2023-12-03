<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import="com.takeo.model.Book" %>
        <%@ page  import="java.util.List" %>
          <%@ page  import="java.util.ArrayList" %>
<html>
<link rel="stylesheet" href="NewFile.css">
<body>

	<div class="container">
	<div>
	<form action="bookInsert" method="POST" class="form1">
		<% if(request.getAttribute("insertRes")!=null && ((String)request.getAttribute("insertRes")).equals("success")){ %>
		<span style="color: green;font-size: 20px"> <%=request.getAttribute("insertRes") %> </span>
		<% }else if(request.getAttribute("insertRes")!=null){ %>
		<span style="color: red;font-size: 20px"> <%=request.getAttribute("insertRes") %> </span>
		<%} %>
		<br><br>
		<br><br>
	<div class="inform">Add your book here</div>
	  <div class="insertMenus">
	  <div>
	  <label for="BookName">Book Name:</label>
	  <input type="text" id="bName" name="bName"><br><br>
	  
	  <label for="Category">Book Category</label>
	  <input type="text" id="category" name="category"><br><br>
	  <label for="BookPrice">Price:</label>
	  <input type="text" id="price" name="price"><br><br>
	  </div>
	  <div>
	  <label for="Author">Author:</label>
	  <input type="text" id="author" name="author"><br><br>
	  
	  <label for="Book Description">Description:</label>
	  <input type="text" id="description" name="description"><br><br>
		</div>
		<input type="submit" class="submit-button" value="Submit">
		</div>
	  
	 
	</form>
	</div>

	<div class="readBook">
	<form  action="readBook" method="get">
	<% if(request.getAttribute("books")!=null){ 
	List<Book> books=(List)request.getAttribute("books");%>
	<table border="1" class="table">
	<tr>
		<th>Book ID</th>
		<th>Book Name</th>
		<th>Book Category</th>
		<th>Price</th>
		<th>Description</th>
		<th>Author</th>
	</tr>
	<%
	for(Book book:books){
		 %>
	<tr>
	<td><%=book.getBookId() %></td>
	<td><%=book.getBookName() %></td>
	<td><%=book.getCategory() %></td>
	<td><%=book.getPrice() %></td>
	<td><%=book.getBookDescription() %></td>
	<td><%=book.getAuthor() %></td>
	</tr>
	
	
	<%
	}%>
	</table>
	<%} %>
	 <input type="submit" value="Show Book List" class="submit-button">
	</form>
	</div>
	
	<div>
	<form action="updateData" method="POST">
	
	
		<% if(request.getAttribute("insertRes")!=null && ((String)request.getAttribute("insertRes")).equals("success")){ %>
		<span style="color: green;font-size: 20px"> <%=request.getAttribute("insertRes") %> </span>
		<% }else if(request.getAttribute("insertRes")!=null){ %>
		<span style="color: red;font-size: 20px"> <%=request.getAttribute("insertRes") %> </span>
		<%} %>
	<br><br>
	<br><br>
	 <div class="inform">Select a bookId, then we will update the record with that id number</div>
	  <label for="Book Id">Book Id:</label>
	  <input type="text" id="bookId" name="bId"><br><br>
		
	  <label for="BookName">Book Name:</label>
	  <input type="text" id="bName" name="bName"><br><br>
	  
	  <label for="Category">Book Category</label>
	  <input type="text" id="category" name="category"><br><br>
	  
	  <label for="BookPrice">Price:</label>
	  <input type="text" id="price" name="price"><br><br>
	  
	  <label for="Book Description">Description:</label>
	  <input type="text" id="description" name="description"><br><br>
	  
	  <label for="Author">Author:</label>
	  <input type="text" id="author" name="author"><br><br>
	  <input type="submit" value="update" name="action" class="submit-button">
	</form>
	</div>
	
	<div>
	<form action="deleteBook" method="POST">
		<% if(request.getAttribute("insertRes")!=null && ((String)request.getAttribute("insertRes")).equals("success")){ %>
		<span style="color: green;font-size: 20px"> <%=request.getAttribute("insertRes") %> </span>
		<% }else if(request.getAttribute("insertRes")!=null){ %>
		<span style="color: red;font-size: 20px"> <%=request.getAttribute("insertRes") %> </span>
		<%} %>
	<br><br>
	<br><br>
		<div class="inform">Select the Book Id that you want to delete</div>
	  <label for="Book Id">Book Id:</label>
	  <input type="text" id="bookId" name="bId"><br><br>
	  <input type="submit" value="delete" name ="action" class="submit-button">
	</form>
	</div>
	</div>

</body>
</html>