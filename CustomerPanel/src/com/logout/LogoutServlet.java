package com.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			UserBean user = new UserBean();
			user.removeCustusername();
			user.removeCustpassword();
			HttpSession session = request.getSession(false);
			session.removeAttribute("currentSessionUser");
			session.invalidate();
			response.sendRedirect("login.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
	}

}
