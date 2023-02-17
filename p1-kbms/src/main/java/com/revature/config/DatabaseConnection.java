package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
  private static Connection connection = null;


	static {
		
			ResourceBundle resourceBundle = ResourceBundle.getBundle("kbms"); 
			String driver =resourceBundle.getString("driver");
			String dburl= resourceBundle.getString("dburl");
			String username =resourceBundle.getString("username"); 
			String password = resourceBundle.getString("password");
			try {
				//Class.forName (driver);
				connection = DriverManager.getConnection (dburl, username, password); 
				} catch (SQLException e) { 
					e.printStackTrace();
				}
		}
	public static Connection getConnection() {
		return connection;
	}
		

}



