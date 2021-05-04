package com.notifier.edituser;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edituser")
public class edituser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(req, resp);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			doProcess(req, resp);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		String option=req.getParameter("action");
		switch (option) {
		case "edit_details":
			doEdit(req,resp);
			break;
		case "fetch_details":
			doFetch(req,resp);
			break;

		default:
			break;
		}
	}

	private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("username");
		
		String name=req.getParameter("Name");
		String old_pass=req.getParameter("old_pass");
		String new_pass=req.getParameter("new_pass");
		edituserDao dao=new edituserDao();
		if(dao.check_pass(email, old_pass))
		{
			
			if(dao.doEdit(email, name, new_pass))
			{
				req.setAttribute("success", "Successfully Updated!");
				doFetch(req, resp);
			}
			else
			{
				req.setAttribute("email", email);
				req.setAttribute("somethingwentwrong", "Something went wrong! Try Again.");
				RequestDispatcher rd=req.getRequestDispatcher("editUser.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("email", email);
			req.setAttribute("oldpasswordwrong", "Old password is wrong! Enter the correct password");
			RequestDispatcher rd=req.getRequestDispatcher("editUser.jsp");
			rd.forward(req, resp);
		}
		
		
	}

	private void doFetch(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("username");
		
		edituserDao dao=new edituserDao();
		String name=dao.fetchUserdetails(email).toUpperCase();
		req.setAttribute("name", name);
		req.setAttribute("email", email);
		RequestDispatcher rd=req.getRequestDispatcher("editUser.jsp");
		rd.forward(req, resp);
		
	}
	
	
	

}
