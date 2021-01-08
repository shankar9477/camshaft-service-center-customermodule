package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Placeorderbean;
import com.deo.Placeorderdeo;

/**
 * Servlet implementation class PlaceorderEditServlet
 */
public class PlaceorderEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			//int custid = ((Integer)request.getAttribute("custid")).intValue();
			HttpSession session = request.getSession(true);
			
			// for ID
			//int custid = (int) session.getAttribute("custid");
			//System.out.println("servlet id ="+custid);
			
			//for order date
			//String custorderdate = (String) session.getAttribute("date");
			//System.out.println("servlet date ="+custorderdate);
			
			//for order id
			int orderid = (int)session.getAttribute("orderid");
			System.out.println("servlate orderid = "+orderid);
			
			String exptime = request.getParameter("exptime");
			System.out.println("servlet time = "+exptime);
			Placeorderbean pc = new Placeorderbean();
			pc.setOrderid(orderid);
			//pc.setCustid(custid);
			pc.setVehino(request.getParameter("vehino"));
			pc.setBrand(request.getParameter("brand"));
			pc.setModel(request.getParameter("model"));
			pc.setServices(request.getParameter("services"));
			//order.setCustorderdate(custorderdate);
			pc.setExptime(request.getParameter("exptime"));
			//order.setCustotherdetails(request.getParameter("custotherdetails"));
			
			int status = Placeorderdeo.update(pc);

			if (status > 0)
			{
				//System.out.println(order.getCustworkorderid());
				
				//request.setAttribute("orderid",order.getCustworkorderid());
				System.out.println("Inserted");
				//int custworkorderid = customerworkorderdeo.getOrderId(order);
				session = request.getSession(false);
				request.setAttribute("orderid", orderid);
				request.getRequestDispatcher("showOrder.jsp").forward(request, response);	
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


