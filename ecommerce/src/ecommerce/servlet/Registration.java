package ecommerce.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.dto.User;
import ecommerce.service.UserService;
import ecommerce.utility.UserValidation;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);

		UserValidation userValidation = new UserValidation();
		Map<String, String> errorMessages = userValidation.validate(user);

		if (errorMessages.size() > 0) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		} else {

			try {
				UserService userService = new UserService();
				if (userService.save(user)) {
					response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("errorMessage", "Some error occured. Try again...");
					request.getRequestDispatcher("registration.jsp").forward(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Some error occured. Try again...");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

		}

	}

}
