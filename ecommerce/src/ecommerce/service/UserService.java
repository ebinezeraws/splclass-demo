package ecommerce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecommerce.dto.User;
import ecommerce.utility.DBConnection;

public class UserService {

	private Connection con;

	public UserService() throws SQLException {
		con = new DBConnection().getConnection();
	}

	public boolean save(User user) {
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into user(username,email,mobile,password) values(?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());

			int count = ps.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
