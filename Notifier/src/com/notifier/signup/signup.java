package com.notifier.signup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class signup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		String User_name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		
		signupDao dao=new signupDao();
		
		try {
			if(dao.check(User_name,email,password))
			{
				
				
				resp.sendRedirect("index.jsp");
			}
			else
			{
				resp.sendRedirect("SignUp.jsp");
				
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
			req.setAttribute("duplicate_email", "Email ID is already taken, Login now");
			rd.forward(req, resp);
			
		}
	}

	

}
