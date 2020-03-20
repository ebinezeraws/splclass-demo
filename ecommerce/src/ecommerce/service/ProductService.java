package ecommerce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecommerce.dto.Product;
import ecommerce.utility.DBConnection;

public class ProductService {

	private Connection connection;

	public ProductService() throws SQLException {
		connection = new DBConnection().getConnection();
	}

	public boolean save(Product product) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into product(name,price,quantity,description) values(?,?,?,?)");
			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getDescription());

			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> getProducts() {
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from product");

			List<Product> productList = new ArrayList<Product>();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDescription(rs.getString("description"));

				productList.add(product);
			}

			return productList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
