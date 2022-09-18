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
		<div style="text-align: center">
			<h2>Contact Us</h2>
			<p>Leave us a message:</p>
		</div>
		<div class="row">
			<div class="column">
				<form action="/about-us">
					<div class="form-group">
						<label>Fullname</label> <input type="text" class="form-control"
							name="about-fullname" placeholder="Enter Your Fullname" required>
					</div>
					<div class="form-group">
						<label>Email Address</label> <input type="email"
							pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"
							class="form-control" name="about-email"
							placeholder="Enter Your Email" required>
					</div>
					<div class="form-group">
						<label>Phone</label> <input type="text" class="form-control"
							name="about-phone" placeholder="Enter Your Phone number" required>
					</div>
					<div class="form-group">
						<label>Message</label>
						<textarea type="text" class="form-control" name="about-message"
							placeholder="Write something.." style="height: 170px" required></textarea>
					</div>
					<div class="text-center">
						<hr class="login">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Submit</button>
						<a type="reset" class="btn btn-primary" href="index.jsp">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>