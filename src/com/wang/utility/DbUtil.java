package com.wang.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	public Connection getConn() {
		
		Connection conn = null;
		try {
			/*
			 * Driver = "com.mysql.jdbc.Driver"; url =
			 * "jdbc:mysql://43.82.163.62/testdb?"; userName = "root"; password
			 * = "morning";
			 */
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
			/* プロパティの取り出し */    
			String Driver = properties.getProperty("Driver"); // JDBCドライバ名
			String url = properties.getProperty("jdbc_url"); // JDBCドライバ名
			String userName = properties.getProperty("jdbc_username"); // JDBCドライバ名
			String password = properties.getProperty("jdbc_password"); // JDBCドライバ名

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
