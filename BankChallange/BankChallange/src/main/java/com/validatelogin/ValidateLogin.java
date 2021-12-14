package com.validatelogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnection.DbConnection;
import com.dbprovider.DbProvider;

public class ValidateLogin {
		static DbProvider d=new DbConnection();
		static Connection con=d.createconnection();
		PreparedStatement ps;
		ResultSet rs;
	
		public boolean authenticate(String username,String password)
		{
			boolean res=false;
			
			try {
				ps=con.prepareStatement("select * from account where Uname=? and Upass=?");
				ps.setString(1, username);
				ps.setString(2, password);
				
				rs=ps.executeQuery();  
				//rs=stmt.executeQuery("select * from user");
				while(rs.next())
				{
					String uName=rs.getString(3);
					String pwd=rs.getString(4);
					System.out.println(uName);
					System.out.println(password);
					//System.out.println(pwd);
					
					if (username.equals(uName) && password.equals(pwd))
					{
						res=true;
					}
					else
					{
						res=false;
					}
				}
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return res;
		}
}
