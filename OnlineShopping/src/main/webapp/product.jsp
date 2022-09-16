<%@page import="cn.Connection.DBCon" %>
<%@page import="cn.Controller.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% 
	User auth = (User) request.getSession().getAttribute("auth");
	if(auth != null){
		request.setAttribute("auth", auth);
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
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Create New Product</div>
			<div class="card-body">
				<form action="product-new" method="post">
					<div class="form-group">
						<label>Product Name</label> <input type="text" class="form-control"
							name="product-name" placeholder="Enter Product Name"
							required>
					</div>
					<div class="form-group">
						<label>Product Price</label> <input type="text"
							class="form-control" name="product-price"
							placeholder="Enter Product Price" required>
					</div>
					<div class="form-group">
						<label>Product Image</label> <input type="text"
							class="form-control" name="product-image"
							placeholder="Enter Your Password" required>
					</div>
					<div class="form-group">
						<label>Product Detail</label> <input type="text"
							class="form-control" name="product-detail"
							placeholder="Enter Product Detail" required>
					</div>					
					<div class="text-center">
						<hr class="product">
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