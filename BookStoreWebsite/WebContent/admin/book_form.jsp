<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create New Book</title>
	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#publishDate" ).datepicker();
  } );
  </script>
  
  
	</head>
<body>
	<jsp:directive.include file="header.jsp"/>

	<div align="center">
	
		<h2>
		<c:if test = "${user != null}">
			Edit Existing Book
		</c:if>
		<c:if test = "${user == null}">
		Create New Book
		</c:if>
		</h2>
	</div>
	
	<div align="center">
 		<c:if test = "${book != null}">
			<form action="update_book" method="post" onsubmit="return validateFormInput()"  enctype="multipart/form-data">
			<input type="hidden" name="bookId" value="${book.bookId}"/>
		</c:if>
		<c:if test = "${book == null}">
			<form action="create_book" method="post" onsubmit="return validateFormInput()" enctype="multipart/form-data">	
		</c:if>
	
	<table>
		<tr>
			<td>Category:</td>
				<td>
					<select name="category">
						<c:forEach items="${listCategory}" var="category">
						
							<c:if test="${category.categoryId eq book.category.categoryId}">
								<option value="${category.categoryId}" selected>
							</c:if>
							<c:if test="${category.categoryId ne book.category.categoryId}">
								<option value="${category.categoryId}" selected>
							</c:if>
								${category.name}
				 			</option>
						</c:forEach>
					</select>
				</td>
		</tr>
	
		<tr>
			<td align="right">Title:</td>
			<td align="left"><input type="text" id="title" name="title" size="20" value="${book.title}"/></td>
		</tr>
		<tr>
			<td align="right">Author</td>
			<td align="left"><input type="text" id="author" name="author" size="20" value="${book.author}"/></td>
		</tr>
			<tr>
			<td align="right">ISBN:</td>
			<td align="left"><input type="text" id="isbn" name="isbn" size="20" value="${book.isbn}"/></td>
		</tr>
			<tr>
			<td align="right">Published Date:</td>
			<td align="left"><input type="text" id="publishDate" name="publishDate" size="20" 
				value="<fmt:formatDate pattern = 'MM/dd/yyyy' value = '${book.updatedOn}'/>" /></td>
			 
		</tr>
		
		<tr>
			<td align="right">Book Image:</td>
			<td align="left"><input type="file" id="bookImage" name="bookImage" size="20"/>
			
			
			</td>
		</tr>
		
	
		<tr>
			<td align="right">Price:</td>
			<td align="left"><input type="text" id="price" name="price" size="20" value="${book.price}"/></td>
		</tr>
		
		<tr>
			<td align="right">Description:</td>
			<td align="left"><textarea rows="10" cols="50" name="description" id="description">${book.description}</textarea></td>
		</tr>
		
		
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="Save">
			<input type="button" value="Cancel" onclick="javascript:history.go(-1);">
			</td>
		</tr>
	</table>
	</form>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
	
</body>
<script type="text/javascript">



function validateFormInput(){
	
	var fieldTitle = document.getElementById("title");
	var fieldAuthorName = document.getElementById("author");
	var fieldISBN = document.getElementById("isbn");
	var fieldPublishDate = document.getElementById("publishDate");
	var fieldBookImage = document.getElementById("bookImage");
	var fieldPrice = document.getElementById("price");
	var fieldDescription = document.getElementById("description");
	
	if(fieldTitle.value.length==0){
		alert("Title is required!");
		fieldTitle.focus();
		return false;
	}
	
	if(fieldAuthorName.value.length==0){
		alert("Author Name is required!");
		fieldAuthorName.focus();
		return false;
	}
	
	if(fieldISBN.value.length==0){
		alert("ISBN is required!");
		fieldISBN.focus();
		return false;
	}
	
	if(fieldPublishDate.value.length==0){
		alert("Published Date is required!");
		fieldPublishDate.focus();
		return false;
	}
	
	if(fieldBookImage.value.length==0){
		alert("Book Image is required!");
		fieldBookImage.focus();
		return false;
	}
	
	if(fieldPrice.value.length==0){
		alert("Price is required!");
		fieldPrice.focus();
		return false;
	}
	
	if(fieldDescription.value.length==0){
		alert("Description is required!");
		fieldDescription.focus();
		return false;
	}
	
	return true;
}




</script>
</html>