package com.notifier.notebook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/notebook")
public class notebook extends HttpServlet {

	String notebookname;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			doProcess(request, response);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			doProcess(req,resp);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		String action=req.getParameter("action");
		//System.out.println(req.getServletPath());
		System.out.println("the action is "+action);
		try
		{
		switch(action)
		{
		case "NoteBooks":
			doShownote(req, resp);
			break;
		case "Add_NoteBook":
			doAddnotebook(req, resp);
			doShownote(req, resp);
			break;
		case "change_notebookname":
			notebookname=req.getParameter("notebookname");
			RequestDispatcher rd=req.getRequestDispatcher("editnotebookname.jsp");
			rd.forward(req, resp);
			
			break;
		case "delete":
				doDeleteNotebookname(req,resp);
				doShownote(req, resp);
			break;
		case "edit_notebookname":
			doEditnotebook(req,resp);
			doShownote(req, resp);
			break;
		default:
			doShownote(req, resp);
			break;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
			HttpSession session=req.getSession();
			session.removeAttribute("username");
			resp.sendRedirect("index.jsp");
		}
		
	}

	private void doEditnotebook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=req.getSession();
		String new_notebookname=req.getParameter("new_notebookname");
		System.out.println("old notebook name:  "+notebookname);
		add_notebook_nameDao dao=new add_notebook_nameDao();
		try {
			if(dao.editNotebookname(session.getAttribute("username").toString(),notebookname,new_notebookname))
			{
				System.out.println("Update successful");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doDeleteNotebookname(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session=req.getSession();
		notebookname=req.getParameter("notebookname");
		System.out.println("delete:    "+notebookname);
		add_notebook_nameDao dao=new add_notebook_nameDao();
		try {
			if(dao.deleteNotebook(session.getAttribute("username").toString(),notebookname))
			{
				System.out.println("Update successful");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doShownote(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		HttpSession session=req.getSession();
		add_notebook_nameDao dao2=new add_notebook_nameDao();
		List<notebook_name_bin> list=dao2.fetchNotebook((String)session.getAttribute("username"));
		//System.out.println(list.get(0).getNotebook_name());
		req.setAttribute("notebook_list", list);
		//System.out.println(dao2.fetchNotebook(session.getAttribute("username").toString()));
		RequestDispatcher rd=req.getRequestDispatcher("notebook.jsp");
		rd.forward(req, resp);
	}

	private void doAddnotebook(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session=req.getSession();
		String notebook_name=req.getParameter("notebookname");
		if(notebook_name.equals(""))
		{
			notebook_name=null;
		}
		add_notebook_nameDao dao=new add_notebook_nameDao();
		try {
			if(dao.addNotebook(session.getAttribute("username").toString(),notebook_name))
			{
				System.out.println("Update successful");
				notebook_name=null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
