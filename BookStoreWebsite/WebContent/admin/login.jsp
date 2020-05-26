<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
		<h2>Admin Login </h2>
		
	<c:if test="${message != null}">
		<div align="center">
			<h4><i> ${message} </i></h4>
	</c:if>
		
		<form id="formLogin" action="login" method="post" onsubmit="return validateFormInput()">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" id="email" size="20"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<button type="submit">Login</button>
					
					</td>
				</tr>
			</table>
		</form>
		
	</div>

</body>

<script type="text/javascript">
function validateFormInput(){
	
	var fieldEmail = document.getElementById("email");

	var fieldPassword = document.getElementById("password");
	
	if(fieldEmail.value.length==0){
		alert("Email is required!");
		fieldEmail.focus();
		return false;
	}
	
	
	if(fieldPassword.value.length==0){
		alert("Password is required!");
		fieldPassword.focus();
		return false;
	}
	
	return true;
}
</script>
</html>