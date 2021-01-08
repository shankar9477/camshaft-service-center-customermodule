package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customerbean;
import com.deo.CustomerLogindeo;


/**
 * Servlet implementation class CustomerLoginServlet
 */
public class CustomerLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		  

		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		      
		    
		    String email=request.getParameter("custusername");  
		    String password=request.getParameter("custpassword");  
		          
		    System.out.println("hi");
		    if(CustomerLogindeo.validate(email, password))
		    { 
		    	System.out.println("welcome");
		    HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser",email);
		    
		    response.sendRedirect("index.jsp");
			/*
			 * RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			 * rd.forward(request,response);
			 */
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		  
	  }

	
}
