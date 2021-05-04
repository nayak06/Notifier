package com.notifier.login;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("email");
		String password=request.getParameter("pass");
		//System.out.print(uname+" "+password);
		loginDao dao=new loginDao();
		
		try {
			if(dao.check(uname, password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("name", dao.getName(uname).toUpperCase());
				session.setAttribute("username", uname);
				response.sendRedirect("dashboard");
				
			}
			else
			{
				response.sendRedirect("index.jsp");
				
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
