package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customerbean;
import com.deo.CustomerRegistrationdeo;

/**
 * Servlet implementation class CustomerRegServlet
 */
public class CustomerRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Customerbean cc = new Customerbean();
				cc.setCustname(request.getParameter("name"));
				cc.setCustemail(request.getParameter("email"));
				cc.setCustpassword(request.getParameter("password"));
				cc.setCustadd(request.getParameter("address"));
				cc.setCuststate(request.getParameter("state"));
				cc.setCustmobile(request.getParameter("mobile"));
				
				
				int status = CustomerRegistrationdeo.save(cc);
				if (status > 0) 
				{
					PrintWriter pw = response.getWriter();
					pw.println("Inserted Successfully!");
					response.sendRedirect("main.jsp");
				}
				else
				{
					response.sendRedirect("customerError.jsp");
				}


			} catch (Exception e) {
				e.printStackTrace();
			}



	}

}
