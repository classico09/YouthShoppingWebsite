package cn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.Connection.DBCon;
import cn.Dao.MessDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/about-us")
public class AboutUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name = request.getParameter("about-fullname");
			String email = request.getParameter("about-email");
			String phone = request.getParameter("about-phone");
			String mess = request.getParameter("about-message");

			try {
				MessDao mdao = new MessDao(DBCon.getConnection());
				boolean flag = mdao.userMess(name, email, mess, phone);

				if (flag == true) {
					out.println(
							"<h3 style='color:crimson; text-align:center'>Message Send Successful.<a href='index.jsp'>Go to Main Page </a>");
				} else {
					response.sendRedirect("about.jsp");
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
