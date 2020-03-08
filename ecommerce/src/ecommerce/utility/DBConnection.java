package ecommerce.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.Driver;

public class DBConnection {

	public Connection getConnection() throws SQLException {
		// 1. register of driver
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/ecommercedb", "sa", "sa");

	}

}
