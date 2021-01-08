package com.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Placeorderbean;

import com.connection.ConnectionManager;

public class Placeorderdeo
{
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	//****************INSERT******************************
	public static int save(Placeorderbean pc) 
	{
		int status = 0;
		PreparedStatement ps = null;
	
		//int custworkorderid = bean.getCustworkorderid();
		//int custid = pc.getCustid();
		//System.out.println(custid);
		String vehino = pc.getVehino();
		String brand = pc.getBrand();
		String model = pc.getModel();
		String services = pc.getServices();
		String exptime = pc.getExptime();
	
		try 
		{
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into placeorder(vehino,brand,model,services,exptime) values(?,?,?,?,?)");
			//ps.setInt(1, custid);
			ps.setString(1, vehino);
			ps.setString(2, brand);
			ps.setString(3, model);
			ps.setString(4, services);
			ps.setString(5, exptime);
	
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
	//****************UPDATE******************************
		public static int update(Placeorderbean pc) 
		{
			int status = 0;
			PreparedStatement ps = null;
		
			int orderid = pc.getOrderid();
			//int custid = bean.getCustid();
			String vehino = pc.getVehino();
			String brand = pc.getBrand();
			String model = pc.getModel();
			String services = pc.getServices();
			String exptime = pc.getExptime();
		
			try 
			{
				currentCon = ConnectionManager.getConnection();
				ps=currentCon.prepareStatement("update placeorder set vehino=?,brand=?,model=?,services=?,exptime=? where orderid=?");
				//ps.setInt(1, custid);
				ps.setString(1, vehino);
				ps.setString(2, brand);
				ps.setString(3, model);
				ps.setString(4, services);
				ps.setString(5, exptime);
				
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
		
		//******************getAllRecords*******************//
	public static List<Placeorderbean> getAllRecords()
	{
		List<Placeorderbean>list=new ArrayList<>();
		int status=0;
		
		try 
		{	
			currentCon=ConnectionManager.getConnection();
			PreparedStatement ps= currentCon.prepareStatement("SELECT * from placeorder");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				{
					Placeorderbean pc = new Placeorderbean();
					pc.setOrderid(rs.getInt("orderid"));
					//bean.setCustid(rs.getInt("custid"));
					pc.setVehino(rs.getString("vehino"));
					pc.setBrand(rs.getString("brand"));
					pc.setModel(rs.getString("model"));
					pc.setServices(rs.getString("services"));
					pc.setExptime(rs.getString("exptime"));
					
					
					list.add(pc);
				}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	//*******Workorder id********************//
	public static int getOrderId(Placeorderbean pc)
	{
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int status = 0;
		
		int orderid = 0;
		//System.out.println(custid);
		//int custid = bean.getCustid();
		String vehino = pc.getVehino();
		String brand = pc.getBrand();
		String model = pc.getModel();
		String services = pc.getServices();
		String exptime = pc.getExptime();
		
		
		try 
		{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();	
				ps=currentCon.prepareStatement("SELECT orderid from placeorder where vehino=? and brand=? and model=? and services=? and exptime=?");
				//ps.setInt(1, custid);
				ps.setString(1, vehino);
				ps.setString(2, brand);
				ps.setString(3, model);
				ps.setString(4, services);
				ps.setString(5, exptime);
				rs = ps.executeQuery();
				if(rs  != null )
				{
					while(rs.next())
					{
						orderid = rs.getInt("orderid");
						status = orderid;
						System.out.println("orderid= "+orderid);
					}
				}
				else
				{
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
	
	//********REcord by id******//
	public static Placeorderbean getRecordById(int orderid)
	{
		Placeorderbean pc = null;
		try 
		{
			currentCon=ConnectionManager.getConnection();
			PreparedStatement pstmt = currentCon.prepareStatement("SELECT * from placeorder where orderid=?");
		    pstmt.setInt(1, orderid);
		    ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				pc = new Placeorderbean();
				//orderbean.setCustworkorderid(rs.getInt("custworkorderid"));
				//orderbean.setCustid(rs.getInt("custid"));
				//System.out.println(rs.getString("vehino"));
				pc.setVehino(rs.getString("vehino"));
				pc.setBrand(rs.getString("brand"));
				pc.setModel(rs.getString("model"));
				pc.setServices(rs.getString("services"));
				pc.setExptime(rs.getString("exptime"));
				//pc.setCustotherdetails(rs.getString("custotherdetails"));
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return pc;
	}
	
	//***********GET CUSTOMER ID**************//
		/*public static int getCustId(int orderid)
		{
			Statement stmt = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int status = 0;
			
			int custid = 0;
			//System.out.println(custid);
			try 
			{
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();	
					ps=currentCon.prepareStatement("SELECT custid from custworkorder where custworkorderid=?");
					ps.setInt(1, orderid);
					rs = ps.executeQuery();
					if(rs  != null )
					{
						while(rs.next())
						{
							custid = rs.getInt("custid");
							status = custid;
							System.out.println("In getCustId method cusid= "+custid);
						}
					}
					else
					{
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
*/}
