<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

<div>

<h1>Our Logo</h1>

</div>

<div>

<input type="text" name="keyword" size="50"/>
<input type="button" value="search"/>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="login">Sign In</a>
<a href="register">Register</a>
<a href="view_cart">Cart</a>

</div>
<div>&nbsp;</div>
<div>
	<c:forEach var ="category" items="${listCategory}" varStatus="status">	
		<a href="view_category?id=${category.categoryId}">
			<font size="+1">
			<b><c:out value="${category.name}"/></b>
			</font>
		</a>
<c:if test="${not status.last}">
&nbsp;|&nbsp;
</c:if>
</c:forEach>
</div>
</div>