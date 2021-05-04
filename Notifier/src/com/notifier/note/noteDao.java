package com.notifier.note;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class noteDao {
	
	String url="jdbc:mysql://localhost:3306/notifier";
	String username="root";
	String password="root";
	
	
	public boolean addNote(String email,String notebookname ,String notename,String startdate,String enddate,String reminddate,String status,String tag,String desc) throws ClassNotFoundException, SQLException
	{
		
		String query="insert into notes(email,notebookname,notename,start_date,end_date,remainder_date,status,tag,Note_description) values(?,?,?,?,?,?,?,?,?);";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, email);
		st.setString(2, notebookname);
		st.setString(3, notename);
		st.setString(4, startdate);
		st.setString(5, enddate);
		st.setString(6, reminddate);
		st.setString(7, status);
		st.setString(8, tag);
		st.setString(9, desc);
		
		if(st.executeUpdate()==1)
		{
			return true;
		}
		return false;
		
	}
	
	public List<note_bin> fetchnote(String email,String notebookname) throws ClassNotFoundException, SQLException
	{
		String query="select slno,upper(notename) as notename,start_date,end_date,remainder_date,status,tag,Note_description from notes where email=? and notebookname=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, email);
		st.setString(2, notebookname);
		List<note_bin> list=new ArrayList<note_bin>();
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			list.add(new note_bin(rs.getString(2), rs.getString(3), rs.getString(6), rs.getString(8), rs.getString(4),rs.getInt(1),rs.getString(5),rs.getString(7)));
		}
		System.out.println("notedao   "+list);
		return list;
	}
	public boolean deleteNote(int slno) throws ClassNotFoundException, SQLException
	{
		
		String delt="Delete from notes where slno=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(delt);
		
		st.setInt(1, slno);
		
		
		if(st.executeUpdate()==1)
		{
			return true;
		}
		return false;
		
	}
	
	public boolean editNote(int slno,String notename,String startdate,String enddate,String reminddate,String status,String tag,String desc) throws SQLException, ClassNotFoundException
	{
		String update="update notes set notename=?,start_date=?,end_date=?,remainder_date=?,status=?,tag=?,Note_Description=? where slno=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(update);
		
		st.setString(1, notename);
		st.setString(2, startdate);
		st.setString(3, enddate);
		st.setString(4, reminddate);
		st.setString(5, status);
		st.setString(6, tag);
		st.setString(7, desc);
		st.setInt(8, slno);
		
		
		
		if(st.executeUpdate()==1)
		{
			return true;
		}
		return false;
	}
}
