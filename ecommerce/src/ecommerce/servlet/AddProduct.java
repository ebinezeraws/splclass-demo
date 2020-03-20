package ecommerce.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ecommerce.dto.Product;
import ecommerce.service.ProductService;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/addProduct")
@MultipartConfig
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");
			String description = request.getParameter("description");

			Part imagePart = request.getPart("image");

			Product product = new Product();
			product.setName(name);
			product.setPrice(Float.parseFloat(price));
			product.setQuantity(Integer.parseInt(quantity));
			product.setDescription(description);
			product.setProductImage(imagePart);

			ProductService productService = new ProductService();
			if (productService.save(product)) {
				String applicationPath = request.getServletContext().getRealPath("/");
				File imagesDir = new File(applicationPath + "/prodimages");
				if (!imagesDir.exists()) {
					imagesDir.mkdir();
				}

				System.out.println(imagesDir.getPath());
				byte[] imageBytes = new byte[imagePart.getInputStream().available()];
				imagePart.getInputStream().read(imageBytes);

				FileOutputStream fileOutputStream = new FileOutputStream(imagesDir + "/" + product.getName() + ".jpg");
				fileOutputStream.write(imageBytes);
				fileOutputStream.flush();
				fileOutputStream.close();

				response.sendRedirect("allproducts");

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Enter proper price and quantity values");
			request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Database error occured. Try again..");
			request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Some internal error occured");
			request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		}

	}

}
