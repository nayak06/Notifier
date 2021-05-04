package com.notifier.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {
	String url="jdbc:mysql://localhost:3306/notifier";
	String username="root";
	String password="root";
	String query="select * from user_details where email=?";
	
	public boolean check(String uname,String pass) throws ClassNotFoundException, SQLException
	{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, uname);
		
		ResultSet rs=st.executeQuery();
		rs.next();
		if(rs.getString(3).equals(pass))
		{
			
			return true;
		}
		
		
		return false;
		
	}
	public String getName(String uname) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, uname);
		
		ResultSet rs=st.executeQuery();
		rs.next();
		return rs.getString(2);
		
	}
}
