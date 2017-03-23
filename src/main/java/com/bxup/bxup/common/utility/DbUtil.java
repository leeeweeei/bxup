package com.bxup.bxup.common.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	public Connection getConn() {
		
		Connection conn = null;
		try {

			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
	  
			String Driver = properties.getProperty("Driver"); 
			String url = properties.getProperty("jdbc_url"); 
			String userName = properties.getProperty("jdbc_username"); 
			String password = properties.getProperty("jdbc_password"); 

			Class.forName(Driver);

			conn = DriverManager.getConnection(url, userName, password);

		} catch (IOException e) {

		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
