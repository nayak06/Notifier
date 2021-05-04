package com.notifier.note;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class note extends HttpServlet {
	
	String notebookname;
	int slno;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("this is note.java");
		try {
			doProcess(req,resp);
		} catch (ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req,resp);
		} catch (ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException, ClassNotFoundException, SQLException {
		
		try
		{
			String url=req.getServletPath();
			//System.out.println(url);
			
			switch(url)
			{
			case "/note_entry":
				doShownotes(req,resp);
				break;
			case "/add_note":
				doAddnote(req,resp);
				break;
			case "/delete":
				doDeletenote(req,resp);
				break;
			case "/change_note":
				slno=Integer.parseInt(req.getParameter("note_slno"));
				RequestDispatcher rd=req.getRequestDispatcher("editNote.jsp");
				rd.forward(req, resp);
				break;
			case "/edit_note":
				doEditenote(req, resp);
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

	private void doEditenote(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		HttpSession session=req.getSession();
		String email=session.getAttribute("username").toString();
		
		
		String notename=req.getParameter("notename");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String reminddate = req.getParameter("reminddate");
		String status=req.getParameter("status");
		String tag=req.getParameter("tag");
		String desc=req.getParameter("description");
		//System.out.println(notename+" "+startdate+" "+enddate+" "+reminddate+" "+status+" "+tag);
//		String startDateStr = req.getParameter("reminddate"); 
//		System.out.println(startDateStr);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
//		Date startDate = sdf.parse(startDateStr);
//		System.out.println(startDate);
		if(notebookname!=null && notename!=null)
		{
			noteDao dao=new noteDao();
			if(dao.editNote(slno, notename, startdate, enddate, reminddate, status, tag, desc))
			{
				System.out.println("update successful");
				noteDao dao2=new noteDao();
				List<note_bin> list=dao2.fetchnote(email, notebookname);
				req.setAttribute("note_list", list);
				RequestDispatcher rd=req.getRequestDispatcher("note.jsp");
				
				rd.forward(req, resp);
			}
		}
		else
		{
			noteDao dao2=new noteDao();
			List<note_bin> list=dao2.fetchnote(email, notebookname);
			req.setAttribute("note_list", list);
			RequestDispatcher rd=req.getRequestDispatcher("note.jsp");
			rd.forward(req, resp);
		}
		
		
		
	}

	private void doDeletenote(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		int note_slno=Integer.parseInt(req.getParameter("note_slno"));
		noteDao dao=new noteDao();
		if(dao.deleteNote(note_slno))
		{
			System.out.println("Delete note successful");
			
			
			noteDao dao2=new noteDao();
			
			HttpSession session=req.getSession();
			String email=session.getAttribute("username").toString();
			
			List<note_bin> list=dao2.fetchnote(email,notebookname);
			
			System.out.println("in note "+list);
			req.setAttribute("note_list",list);
			RequestDispatcher rd=req.getRequestDispatcher("note.jsp");
			rd.forward(req, resp);	
		}
		
	}

	private void doAddnote(HttpServletRequest req, HttpServletResponse resp) throws ParseException, ClassNotFoundException, SQLException, ServletException, IOException {
		//System.out.println("addnote er vetor");
		HttpSession session=req.getSession();
		String email=session.getAttribute("username").toString();
		
		
		String notename=req.getParameter("notename");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String reminddate = req.getParameter("reminddate");
		String status=req.getParameter("status");
		String tag=req.getParameter("tag");
		String desc=req.getParameter("description");
		//System.out.println(notename+" "+startdate+" "+enddate+" "+reminddate+" "+status+" "+tag);
//		String startDateStr = req.getParameter("reminddate"); 
//		System.out.println(startDateStr);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
//		Date startDate = sdf.parse(startDateStr);
//		System.out.println(startDate);
		if(notebookname!=null && notename!=null)
		{
			noteDao dao=new noteDao();
			if(dao.addNote(email, notebookname, notename, startdate, enddate, reminddate, status, tag, desc))
			{
				System.out.println("update successful");
				noteDao dao2=new noteDao();
				List<note_bin> list=dao2.fetchnote(email, notebookname);
				req.setAttribute("note_list", list);
				RequestDispatcher rd=req.getRequestDispatcher("note.jsp");
				
				rd.forward(req, resp);
			}
		}
		else
		{
			noteDao dao2=new noteDao();
			List<note_bin> list=dao2.fetchnote(email, notebookname);
			req.setAttribute("note_list", list);
			RequestDispatcher rd=req.getRequestDispatcher("note.jsp");
			rd.forward(req, resp);
		}
		
	}

	private void doShownotes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		notebookname=req.getParameter("notebook_name");
		System.out.println("passed notebook name    "+notebookname);
		noteDao dao2=new noteDao();
		
		HttpSession session=req.getSession();
		String email=session.getAttribute("username").toString();
		
		List<note_bin> list=dao2.fetchnote(email,notebookname);
		
		System.out.println("in note "+list);
		req.setAttribute("note_list",list);
		RequestDispatcher rd=req.getRequestDispatcher("note.jsp");
		rd.forward(req, resp);
		
		
	}

	

	
}
