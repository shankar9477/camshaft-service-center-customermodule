package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager 
{
	static Connection con;
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/camshaft", "root", "root");
		return con;
	}

}
