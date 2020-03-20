package ecommerce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.dto.User;
import ecommerce.service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			UserService userService = new UserService();
			User user = userService.login(username, password);

			if (user != null) {

				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("homepage.jsp");

			} else {
				request.setAttribute("errorMessage", "Invalid Credentails");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Some internal error. Try again... Sorry");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
