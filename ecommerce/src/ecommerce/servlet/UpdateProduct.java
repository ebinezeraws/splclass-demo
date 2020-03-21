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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");
			String description = request.getParameter("description");

			Product product = new Product();
			product.setId(Integer.parseInt(id));
			product.setName(name);
			product.setPrice(Float.parseFloat(price));
			product.setQuantity(Integer.parseInt(quantity));
			product.setDescription(description);

			/* Validate product details */

			ProductService productService = new ProductService();
			if (productService.update(product)) {
				response.sendRedirect("allproducts");
			} else {
				request.setAttribute("errorMessage", "Some Internal error Occured");
				request.getRequestDispatcher("editproduct.jsp").forward(request, response);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Enter proper price and quanity");
			request.getRequestDispatcher("editproduct.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Some Internal error Occured");
			request.getRequestDispatcher("editproduct.jsp").forward(request, response);
		}

	}

}
