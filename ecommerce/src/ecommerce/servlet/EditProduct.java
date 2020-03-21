package ecommerce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.dto.Product;
import ecommerce.service.ProductService;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		try {
			Integer productId = Integer.parseInt(id);
			ProductService productService = new ProductService();
			Product product = productService.getProduct(productId);
			if (product != null) {
				request.setAttribute("product", product);
				request.getRequestDispatcher("editproduct.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "No Product found the id" + productId);
				request.getRequestDispatcher("allproducts").forward(request, response);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "some Interal error occured");
			request.getRequestDispatcher("allproducts").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "some Interal error occured");
			request.getRequestDispatcher("allproducts").forward(request, response);
		}
	}

}
