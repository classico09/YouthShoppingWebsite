package cn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.Connection.DBCon;
import cn.Dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/product-new")
public class ProductNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("product.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String name = request.getParameter("product-name");
			double price = Double.parseDouble(request.getParameter("product-price"));
			String image = request.getParameter("product-image");
			String detail = request.getParameter("product-detail");
			
			try {
				ProductDao pdao = new ProductDao(DBCon.getConnection());
				boolean flag = pdao.productNew(name, price, image, detail);

				if(flag == true) {
					out.println("<h3 style='color:crimson; text-align:center'>Add Product Successful.<a href='index.jsp'>Go to Main Page </a>");
				}else {
					response.sendRedirect("product.jsp");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
