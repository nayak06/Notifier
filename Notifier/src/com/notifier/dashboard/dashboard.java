package com.notifier.dashboard;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notifier.note.noteDao;
import com.notifier.note.note_bin;

@WebServlet("/dashboard")
public class dashboard extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		try
		{
			String username=session.getAttribute("username").toString();
			String name=session.getAttribute("name").toString();
			System.out.println(username);
			request.setAttribute("username", username);
			request.setAttribute("name", name);
			if(session.getAttribute("username")==null)
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				
				dashboardDao dao2=new dashboardDao();
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				System.out.println("tosday date "+dtf.format(now));

				
				String email=session.getAttribute("username").toString();
				List<remindNotificationBin> list2=dao2.fetchRemind(dtf.format(now),email);
				List<dashboardBin> list=dao2.fetchnote(email);
				System.out.println("dashboard list "+list);
				request.setAttribute("note_list", list);
				request.setAttribute("remind_list", list2);
				
				request.setAttribute("reminder_nos", list2.size());
				
				RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			System.out.print(e);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	
	

}
