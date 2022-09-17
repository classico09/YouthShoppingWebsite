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


@WebServlet("/register-new")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String name = request.getParameter("register-fullname");
			String email = request.getParameter("register-email");
			String pass = request.getParameter("register-password");
			String phone = request.getParameter("register-phone");
			String repass = request.getParameter("register-repassword");
			
			if(repass == pass) {
				try {
					UserDao udao = new UserDao(DBCon.getConnection());
					boolean flag = udao.userRegister(name, email, pass, phone);

					if(flag == true) {
						out.println("<h3 style='color:crimson; text-align:center'>Register Successful.<a href='login.jsp'>Go to Login Page </a>");
					}else {
						response.sendRedirect("register.jsp");
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else {
				out.println("<h3 style='color:crimson; text-align:center'>Password and Re-Password are not correct.<a href='register.jsp'>Return to Register Page</a>");
			}
		}
			
			
	}

}
