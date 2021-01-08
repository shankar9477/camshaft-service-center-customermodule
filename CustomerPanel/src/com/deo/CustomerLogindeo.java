package com.deo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CustomerLogindeo
{

	public static boolean validate(String email,String password)
	{  
		boolean status=false;  
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/camshaft","root","root");  
		      
		PreparedStatement ps=con.prepareStatement("select * from customer where email=? and password=?");  
		ps.setString(1,email);  
		ps.setString(2,password);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}
		catch(Exception e)
		{
			System.out.println(e);
			}  
		return status;  
		}  
}
