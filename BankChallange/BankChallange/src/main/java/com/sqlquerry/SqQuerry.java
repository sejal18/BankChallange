package com.sqlquerry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Account.Account;
import com.dbconnection.DbConnection;
import com.dbprovider.DbProvider;

public class SqQuerry {
	static DbProvider d=new DbConnection();
	static Connection con=d.createconnection();
	static PreparedStatement pst=null;
	
	
	public void insertData(int accno,String accType,String username,String password,String sq,String hint)
	{

		   
		    double bal=0;
		try
		{    
			pst=con.prepareStatement("insert into account values(?,?,?,?,?,?,?)");
			pst.setInt(1,accno);
			pst.setString(2, accType);
			pst.setString(3, username);
			pst.setString(4, password);
			pst.setDouble(5, bal);
			pst.setString(6, sq);
			pst.setString(7, hint);
            pst.executeUpdate();
            
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	public void deleteAc(String uname) {

		try {
			PreparedStatement stmt=con.prepareStatement("Delete FROM account where uname=?");

			stmt.setString(1, uname);
			stmt.executeUpdate();
		
		
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		
		
		
}
	
	
	
	
	public Account getData(String uname) {
		
		Account b=new Account();
		
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT *FROM account where uname=?");
			stmt.setString(1, uname);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
			 b.setAccNo(rs.getInt(1));
			 b.setType(rs.getString(2));
			 b.setName(rs.getString(3));
			 b.setPass(rs.getString(4));
			 b.setBal(rs.getDouble(5));
			 b.setSq(rs.getString(6));
			 b.setHint(rs.getString(7));


			 
			//System.out.println(rs.getInt(0));
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}return b;
		
		
	}	public Account acc(int accno) {
		
		Account b=new Account();
		System.out.println("in q");
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT *FROM account where acc_no=?");
			System.out.println("in u");

			stmt.setInt(1, accno);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
			 b.setAccNo(rs.getInt(1));
			 b.setType(rs.getString(2));
			 b.setName(rs.getString(3));
			 b.setPass(rs.getString(4));
			 b.setBal(rs.getDouble(5));
			 b.setSq(rs.getString(6));
			 b.setHint(rs.getString(7));
             System.out.println(rs.getString(3));

			 
			//System.out.println(rs.getInt(0));
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}return b;
		
		
	}
	

	
	public void updateBal(int acc,double bal) {
		try{
			pst=con.prepareStatement("update  account set acc_bal=? where acc_no=?");
			pst.setDouble(1, bal);
			pst.setInt(2, acc);
			int cnt=pst.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public String changePass(int accno,String newpass) {
		try{
			pst=con.prepareStatement("update  account set upass=? where acc_no=?");
			pst.setString(1, newpass);
			pst.setInt(2, accno);
			int cnt=pst.executeUpdate();
			if (cnt>0){
				return "password updated!!!";
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}return "";
		
	}
	
	
	
	public double getBal(int accNo) {
		ResultSet rs = null;
		double a=0;
		try {
			pst=con.prepareStatement("SELECT *FROM account where acc_no=?");
			pst.setInt(1, accNo);
			rs=pst.executeQuery();
			
		
			while(rs.next()) {
				a=rs.getDouble(5);
		    
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}return a;
	}

	public static void main(String[] args) {
		SqQuerry s=new SqQuerry();
	  //s.getData();
	  //s.updateBal(11, 4000);
      // s.getBal(11);
		//s.getData("df");
		
	  

	}

}
