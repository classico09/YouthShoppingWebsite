<nav class="navbar navbar-expand-lg bg-light">
	<div class="container">
		<a class="navbar-brand" href="#">Youth Shop</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				</li>
			</ul>
			<form class="d-flex">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">					
				<%
				if(auth != null){%>
					<li class="nav-item"><a class="nav-link" href=""><p class="text-primary">${auth.getName() }</p></a>
					<%
					if(auth.getName() != "admin"){%>
						<li class="nav-item"><a class="nav-link" href="product.jsp">Product</a>
					<%}%>
					<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge bg-dark text-white ms-1 rounded-pill">${cart_list.size()}</span> </a></li>
					<li class="nav-item"><a class="nav-link" href="log-out">Logout</a>					
				<%}else{%>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge bg-dark text-white ms-1 rounded-pill">${cart_list.size()}</span> </a></li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				<%}
				%>				
				</ul>
			</form>
		</div>
	</div>
</nav>