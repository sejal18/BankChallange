package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.dbprovider.DbProvider;

public class DbConnection implements DbProvider {
	Connection con=null;

	public   Connection createconnection(){ 
		
		try {

		Class.forName("com.mysql.cj.jdbc.Driver");

	
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankaccount?autoReconnect=true&useSSL=false","root","rootuser");
		
		
		//System.out.println("d
		}catch(Exception e) {
			e.printStackTrace();
			
		}return con;
}

}
