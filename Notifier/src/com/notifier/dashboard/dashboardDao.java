package com.notifier.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.notifier.note.note_bin;

public class dashboardDao {

	String url="jdbc:mysql://localhost:3306/notifier";
	String username="root";
	String password="root";
	
	public List<dashboardBin> fetchnote(String email) throws ClassNotFoundException, SQLException
	{
		String query="select slno,upper(notename) as notename,start_date,end_date,remainder_date,status,tag,Note_description,upper(notebookname) from notes where email=? ";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, email);
		
		List<dashboardBin> list=new ArrayList<dashboardBin>();
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			list.add(new dashboardBin(rs.getString(9),rs.getString(2), rs.getString(3), rs.getString(6), rs.getString(8), rs.getString(4),rs.getInt(1),rs.getString(5),rs.getString(7)));
		}
		return list;
	}
	
	public List<remindNotificationBin> fetchRemind(String date,String email) throws SQLException, ClassNotFoundException
	{
		String query="select notename,remainder_date from notes where remainder_date=? and email=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, date);
		st.setString(2, email);
		
		List<remindNotificationBin> list=new ArrayList<remindNotificationBin>();
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			list.add(new remindNotificationBin(rs.getString(1),rs.getString(2)));
		}
		return list;
	}
}
