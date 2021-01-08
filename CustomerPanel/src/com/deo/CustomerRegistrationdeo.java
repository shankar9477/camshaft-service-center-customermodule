package com.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import com.bean.Customerbean;
import com.connection.ConnectionManager;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

public class CustomerRegistrationdeo 
{
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	//****************INSERT******************************
	
	
	
	public static int save(Customerbean bean) 
	{
		int status = 0;
		PreparedStatement ps = null;
	   
	    String custname = bean.getCustname();
		String custadd = bean.getCustadd();
		String custstate = bean.getCuststate();
		String custmobile = bean.getCustmobile();
		String custemail = bean.getCustemail();
		String custpassword = bean.getCustpassword();
		
		
		
		try 
		{
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into customer(name,email,password,address,state,mobile) values(?,?,?,?,?,?)");
			
			
			ps.setString(1, custname);
			ps.setString(2, custemail);
			ps.setString(3, custpassword);
			ps.setString(4, custadd);
			ps.setString(5, custstate);
			ps.setString(6, custmobile);

        	status=ps.executeUpdate();
        	
		} 
		catch (Exception e) 
		{
			System.out.println("Insertion failed : An exception has occured! "+e);
		}
		finally 
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				ps = null;
			}
			if(currentCon != null)
			{
				try 
				{
					currentCon.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				currentCon = null;
			}
		}
		return status;
	}
	
	//************Check user name valid or not************//
	public static int checkEmailorMobile(Customerbean bean)
	{
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int status = 0;
		
		String custemailormobile = bean.getCustemailormobile();
		
		Pattern p = Pattern.compile("[-+]?[0-9]*\\\\.?[0-9]+");  //pattern for mobile no.
		java.util.regex.Matcher m = p.matcher(custemailormobile);
		int custid;
		try 
		{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			//*************For email**********************
			if(custemailormobile.contains("@"))
			{
				ps=currentCon.prepareStatement("SELECT custid,custpassword from custregi where custemail=?");
				ps.setString(1, custemailormobile);
				rs = ps.executeQuery();
				if(rs  != null )
				{
					while(rs.next())
					{
						custid = rs.getInt("custid");
						status = custid;
						System.out.println("ID for email = "+status);
					}
				}
				else
				{
					status = 0;
				}
				
			}
			//*************For mobile no*********************
			else if( m != null)
			{
				ps=currentCon.prepareStatement("SELECT custid,custpassword from custregi where custmobile=?");
				ps.setString(1, custemailormobile);
				rs = ps.executeQuery();
				if(rs != null )
				{
					while(rs.next())
					{
						custid = rs.getInt("custid");
						status = custid;
						System.out.println("iD fo no."+status);
					}
					//status = custid;
				}
				else
				{
					System.out.println("rs = null"+custemailormobile);
					status = 0;
				}
			}
			else
			{
				System.out.println("3rd else maddhe");
				status = 0;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Login failed : An exception has occured! "+e);
		}
		finally 
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				rs = null;
			}
			if(stmt != null)
			{
				try 
				{
					stmt.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				stmt = null;
			}
			if(currentCon != null)
			{
				try 
				{
					currentCon.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				currentCon = null;
			}
		}
		return status;
	}
	
	//***********************LOGIN*********************************
	public static Customerbean login(Customerbean bean)
	{
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String custemailormobile = bean.getCustemailormobile();
		String custpassword = bean.getCustpassword();
		int custid = bean.getCustid();
		
		try 
		{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			//********LOGIN WITH EMAIL AND PASSWORD******//
			if(custemailormobile.contains("@"))
			{
				String email = "";
				String password = "";
				ps=currentCon.prepareStatement("SELECT custemail, custpassword from custregi where custid=?");
				ps.setInt(1, custid);
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					email = rs.getString("custemail");
					password = rs.getString("custpassword");
					System.out.println("Email = "+email);
					System.out.println("password = "+password);
				}
				
				if(email.equals(custemailormobile) && password.equals(custpassword))
				{
					bean.setValid(true);	
				}
				else
				{
					bean.setValid(false);
				}	
			}
			//*******LOGIN WITH MOBILE AND PASSWORD
			else
			{
				String mobile = "";
				String password = "";
				ps=currentCon.prepareStatement("SELECT custmobile, custpassword from custregi where custid=?");
				ps.setInt(1, custid);
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					mobile = rs.getString("custmobile");
					password = rs.getString("custpassword");
					System.out.println("mobile = "+mobile);
					System.out.println("password = "+password);
				}
				
				if(mobile.equals(custemailormobile) && password.equals(custpassword))
				{
					bean.setValid(true);	
				}
				else
				{
					bean.setValid(false);
				}	
			}
		} 
		catch (Exception e) 
		{
			System.out.println("catch Login failed : An exception has occured! "+e);
		}
		finally 
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				rs = null;
			}
			if(stmt != null)
			{
				try 
				{
					stmt.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				stmt = null;
			}
			if(currentCon != null)
			{
				try 
				{
					currentCon.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				currentCon = null;
			}
			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				ps = null;
			}
		}
		return bean;
	}
	
	//******************FOR USER NAME****************************//
	public static Customerbean getUsername(int custid)
	{
		Customerbean bean=null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String username="";
		System.out.println("in method"+custid);
		try 
		{
			bean = new Customerbean();
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ps = currentCon.prepareStatement("select * from custregi where custid=?");
			ps.setInt(1,custid);
			rs = ps.executeQuery();
			//rs = stmt.executeQuery("select * from custregistration where custid="+custid);
			while(rs.next())
			{
				username = rs.getString("custname");
				System.out.println(username);
			}
			bean.setCustname(username);
		} 
		catch (Exception e) 
		{
			System.out.println("error : An exception has occured! "+e);
		}
		finally 
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				rs = null;
			}
			if(stmt != null)
			{
				try 
				{
					stmt.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				stmt = null;
			}
			if(currentCon != null)
			{
				try 
				{
					currentCon.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				currentCon = null;
			}
		}
		return bean;
	}

	//********REcord by id******//
		public static Customerbean getRecordById(int custid)
		{
			Customerbean custbean = null;
			try 
			{
				currentCon=ConnectionManager.getConnection();
				PreparedStatement pstmt = currentCon.prepareStatement("SELECT * from custregi where custid=?");
			    pstmt.setInt(1, custid);
			    ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					custbean = new Customerbean();
					custbean.setCustname(rs.getString("custname"));
					custbean.setCustadd(rs.getString("custadd"));

					custbean.setCuststate(rs.getString("custstate"));
					custbean.setCustmobile(rs.getString("custmobile"));
					custbean.setCustemail(rs.getString("custemail"));
					custbean.setCustpassword(rs.getString("custpassword"));
					
					//custbean.setCustcity(rs.getString("custcity"));
				}	
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return custbean;
		}


}
