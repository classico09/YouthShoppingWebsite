<%@page import="cn.Controller.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	response.sendRedirect("index.jsp");
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div style="text-align: center">
			<h2>About Us</h2>
			<p>This is a online shopping. We sell clothes for men, women and
				also children.</p>
		</div>
		<div class="column">
			<img src="images/about.jpg" style="width: 100%">
		</div>		
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>