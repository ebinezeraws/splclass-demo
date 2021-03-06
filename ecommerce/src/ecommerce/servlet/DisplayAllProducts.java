package ecommerce.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.dto.Product;
import ecommerce.service.ProductService;

/**
 * Servlet implementation class DisplayAllProducts
 */
@WebServlet("/allproducts")
public class DisplayAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ProductService productService = new ProductService();
			List<Product> productList = productService.getProducts();
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("manageproducts.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Some Internal error occurred");
			request.getRequestDispatcher("manageproducts.jsp").forward(request, response);
		}
	}

}
