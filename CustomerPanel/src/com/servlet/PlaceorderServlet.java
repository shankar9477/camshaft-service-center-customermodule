package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Placeorderbean;
import com.deo.Placeorderdeo;

/**
 * Servlet implementation class PlaceorderServlet
 */
public class PlaceorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		try 
		{
			//int custid = ((Integer)request.getAttribute("custid")).intValue();
			HttpSession session = request.getSession(true);
			
			System.out.println("****************************");
			// for ID
			//int custid = (int) session.getAttribute("custid");
			//System.out.println("servlet id ="+custid);
			
			//for order date
			//String custorderdate = (String) session.getAttribute("date");
			//System.out.println("servlet date ="+custorderdate);
			
			//for expected time
			/*String custexpectedtime = request.getParameter("custexpectedtime");
			System.out.println("servlet time = "+custexpectedtime);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			  String date = sdf.format(custexpectedtime);
			  System.out.println("servlet date = "+date);*/
			  
			String exptime = request.getParameter("exptime");
			System.out.println("servlet time = "+exptime);
			Placeorderbean pc = new Placeorderbean();
			//pc.setCustid(custid);
			pc.setVehino(request.getParameter("vehino"));
			pc.setBrand(request.getParameter("brand"));
			pc.setModel(request.getParameter("model"));
			pc.setServices(request.getParameter("services"));
			pc.setExptime(request.getParameter("exptime"));
	
			
			int status = Placeorderdeo.save(pc);

			if (status > 0)
			{
				//System.out.println(order.getCustworkorderid());
				
				//request.setAttribute("orderid",order.getCustworkorderid());
				System.out.println("Inserted");
				int orderid = Placeorderdeo.getOrderId(pc);
				session = request.getSession(false);
				request.setAttribute("orderid",orderid);
				request.getRequestDispatcher("viewOrder.jsp").forward(request, response);	
			}
			else
				response.sendRedirect("rougherror.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}


}
