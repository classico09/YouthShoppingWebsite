package cn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.Connection.DBCon;
import cn.Controller.User;
import cn.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-email");
			String pass = request.getParameter("login-password");
			
			try {
				UserDao udao = new UserDao(DBCon.getConnection());
				User user = udao.userLogin(email, pass);

				if(user != null) {
					request.getSession().setAttribute("auth", user);
					System.out.println(user);
					response.sendRedirect("index.jsp");
				}else {
					response.sendRedirect("login.jsp");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
