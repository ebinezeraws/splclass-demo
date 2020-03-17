package ecommerce.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.dto.User;
import ecommerce.service.UserService;
import ecommerce.utility.UserValidation;

@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setUsername(username);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);

		UserValidation userValidation = new UserValidation();
		Map<String, String> errorMessages = userValidation.validate(user);

		System.out.println(errorMessages);

		if (errorMessages.size() > 0) {
			req.setAttribute("errorMessages", errorMessages);
			req.getRequestDispatcher("editprofile.jsp").forward(req, resp);
		} else {
			try {
				UserService userService = new UserService();
				if (userService.update(user)) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					resp.sendRedirect("profile.jsp");
				} else {
					req.setAttribute("errorMessage", "Some internal error occured");
					req.getRequestDispatcher("editprofile.jsp").forward(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				req.setAttribute("errorMessage", "Some internal error occured");
				req.getRequestDispatcher("editprofile.jsp").forward(req, resp);
			}

		}

	}

}
