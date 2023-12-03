package com.takeo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection con = null;

	public static  Connection getConnection() throws ClassNotFoundException, SQLException {

		Class c = Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sn", "root", "yukiBaby7!");
		
		return con;
	}

	public static void closeConnection() throws SQLException {
		if (con == null) {
         con.close();
		}
	}

}
