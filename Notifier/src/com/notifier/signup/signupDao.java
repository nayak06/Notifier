package com.notifier.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class signupDao {
	String url="jdbc:mysql://localhost:3306/notifier";
	String username="root";
	String password="root";
	String query="insert into user_details values(?,?,?);";
	
	public boolean check(String uname,String email,String pass) throws ClassNotFoundException, SQLException
	{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, email);
		st.setString(2, uname);
		st.setString(3, pass);
		
		if(st.executeUpdate()==1)
		{
			return true;
		}
		
		
		
		
		return false;
		
	}
}
