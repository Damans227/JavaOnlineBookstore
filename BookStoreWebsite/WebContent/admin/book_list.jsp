<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Manage Books - Evergreen Bookstore Administration</title>
	</head>
<body>
	<jsp:directive.include file="header.jsp"/>

	<div align="center">
		<h2>Books Management</h2>
		<a href="new_book">Create new books</a>
		</br></br>
	</div>
	<c:if test="${message != null}">
		<div align="center">
			<h4><i> ${message} </i></h4>
	</c:if>
	
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Price</th>
				<th>Last Updated</th>
				<th>Author</th>
			</tr>
			<c:forEach var="book" items="${listBooks}" varStatus="status">
			<tr>
			<td>${status.index + 1}</td>
			<td>${book.bookId}</td>
			<td><img src="data:image/jpg;base64,${book.base64Image}" width="84" height="110"/></td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.category.name}</td>
			<td>${book.price}</td>
			<td>${book.updatedOn}</td>
			<td>
			<a href="edit_book?id=${book.bookId}">Edit</a>&nbsp;&nbsp;
			<a href="javascript:confirmDelete(${book.bookId})">Delete</a>
			</td>
			</tr></c:forEach>
		
	
		</table>
		
	</div>

	<jsp:directive.include file="footer.jsp"/>
	
</body>
<script>
function confirmDelete(bookId){
	if(confirm('Are you sure you want to delete the book with ID ' + bookId + ' ?')){
		window.location = 'delete_book?id=' +bookId;
	}
	
}

</script>

</html>