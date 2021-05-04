package com.notifier.notebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class add_notebook_nameDao {

	String url="jdbc:mysql://localhost:3306/notifier";
	String username="root";
	String password="root";
	
	
	
	
	public boolean addNotebook(String email,String notebook_name) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		String updt="insert into notebook(email,notebook_name) values(?,?);";
		PreparedStatement st=con.prepareStatement(updt);
		
		st.setString(1, email);
		st.setString(2, notebook_name);
		
		
		if(st.executeUpdate()==1)
		{
			return true;
		}
		return false;
	}
	
	public List<notebook_name_bin> fetchNotebook(String email) throws SQLException, ClassNotFoundException
	{
		List<notebook_name_bin> list=new ArrayList<notebook_name_bin>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		String updt="select upper(notebook_name) from Notebook where email=?";
		String no_of_notes="SELECT count(notebookname) as count FROM notes where email= ? and notebookname=?;";
		//String qry="select count from Notes where notebookname=?";
		PreparedStatement st=con.prepareStatement(updt);
		PreparedStatement st2=con.prepareStatement(no_of_notes);
		
		
		st.setString(1, email);
		ResultSet rs=st.executeQuery();
		
		while(rs.next())
		{
			 st2.setString(1, email);
			 st2.setString(2, rs.getString(1));
			 ResultSet rs2=st2.executeQuery();
			 rs2.next();
			 list.add(new notebook_name_bin(rs.getString(1),rs2.getInt(1)));
		}
		System.out.println("count list "+list);
		return list;
		
	}
	
	public boolean deleteNotebook(String email,String notebookname) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		String delt_notename="DELETE FROM notebook WHERE email=? and notebook_name = ?;";
		String delt_note="Delete from notes where email=? and notebookname=?";
		PreparedStatement st=con.prepareStatement(delt_notename);
		PreparedStatement st2=con.prepareStatement(delt_note);
		
		st.setString(1,email);
		st.setString(2, notebookname);
		st2.setString(1,email);
		st2.setString(2, notebookname);
		if(st.executeUpdate()==1 && st2.executeUpdate()==1)
		{
			System.out.println("Delete successful");
			return true;
		}
		return false;
		
	}
	
	public boolean editNotebookname(String email,String notebookname,String new_notebookname) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		String updt="UPDATE notebook SET notebook_name = ? WHERE email=? and notebook_name = ?;";
		String updt_note="UPDATE notes SET notebookname = ? WHERE email=? and notebookname = ?;";
		PreparedStatement st=con.prepareStatement(updt);
		PreparedStatement st2=con.prepareStatement(updt_note);
		st.setString(1,new_notebookname);
		st.setString(2, email);
		st.setString(3, notebookname);
		
		st2.setString(1,new_notebookname);
		st2.setString(2, email);
		st2.setString(3, notebookname);
		if(st.executeUpdate()==1 && st2.executeUpdate()==1)
		{
			return true;
		}
		return false;
	}
	
	
}
