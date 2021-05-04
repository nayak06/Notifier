package com.notifier.edituser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.notifier.dashboard.remindNotificationBin;

public class edituserDao {
	
	String url="jdbc:mysql://localhost:3306/notifier";
	String username="root";
	String password="root";
	
	public String fetchUserdetails(String email) throws ClassNotFoundException, SQLException
	{
		String query="select name from user_details where email=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		
		st.setString(1, email);
		
		
		ResultSet rs=st.executeQuery();
		rs.next();
		System.out.println(rs.getString(1));
		String name=rs.getString(1);
		return name;
	}
	public boolean doEdit(String email,String name,String new_password) throws ClassNotFoundException, SQLException
	{
		String updt="update user_details set name=?,password=? where email=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(updt);
		
		
		st.setString(1, name);
		st.setString(2, new_password);
		st.setString(3, email);
		
		
		
		if(st.executeUpdate()==1)
		{
			return true;
		}
		return false;
	}
	public boolean check_pass(String email,String old_pass) throws ClassNotFoundException, SQLException
	{
		String query="select email,password from user_details where email=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		
		st.setString(1, email);
		ResultSet rs=st.executeQuery();
		rs.next();
		if(rs.getString(2).equals(old_pass))
		{
			return true;
		}
		return false;
		
	}

}
