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
			<div class="card-header text-center">User Register</div>
			<div class="card-body">
				<form action="register-new" method="post">
					<div class="form-group">
						<label>Fullname</label> <input type="text" class="form-control"
							name="register-fullname" placeholder="Enter Your Fullname"
							required>
					</div>
					<div class="form-group">
						<label>Email Address</label> <input type="email" pattern="/^.!#$%&’*+=?^`{|}~-[]"
							class="form-control" name="register-email"
							placeholder="Enter Your Email" required>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="register-password"
							placeholder="Enter Your Password" required>
					</div>
					<div class="form-group">
						<label>Re Password</label> <input type="password"
							class="form-control" name="register-repassword"
							placeholder="Enter Your Password Again" required>
					</div>
					<div class="form-group">
						<label>Phone</label> <input type="text" class="form-control"
							name="register-phone" placeholder="Enter Your Phone number"
							required>
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