package ecommerce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	
	public User login(String username, String password){
		try {
		PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
		ps.setString(1, username);
		ps.setString(2,password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobile"));
			user.setPassword(rs.getString("password"));
			user.setConfirmPassword(rs.getString("password"));
			return user;
		}else {
			return null;
		}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
