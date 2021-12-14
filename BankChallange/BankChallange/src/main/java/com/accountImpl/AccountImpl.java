package com.accountImpl;

import com.Account.Account;
import com.accnovalidation.ValidAccNo;
import com.dbconnection.DbConnection;
import com.dbprovider.DbProvider;
import com.sqlquerry.SqQuerry;
import com.validatelogin.ValidateLogin;

public class AccountImpl {
 static DbProvider d=new DbConnection();
 static ValidateLogin v=new ValidateLogin();
 static Account a=new Account();
 static SqQuerry s=new SqQuerry();
 static ValidAccNo ac=new ValidAccNo();
 static int acno=100;

public String OpenAccount(String accType,String username,String password,String sq,String hint)

{  acno++;
	s.insertData(acno, accType, username, password, sq, hint);
	return "Account open Successfully with No"+acno;
}
 
 
 
	public String Withdraw(int accno,double amt)
	{			double  bal=0.0;
			System.out.println(1);
			System.out.println(2);
			

       		if(s.getBal(accno)>amt) {
    			System.out.println(1);

			 //System.out.println(a.getBal());
			 bal=s.getBal(accno)-amt;
			 s.updateBal(accno, bal);
				System.out.println(3);
 
			 
			return "Transection Done your bal is "+bal; 
		
		
	}return "Not Sufficient  bal  "+s.getBal(accno); 

	  
	}
	public String deposit(int accno,double amt) {
		
		  
		double bal=s.getBal(accno)+amt;
		s.updateBal(accno, bal);
		return "Upadated Successfully";
		 
		 
		
		
		
		
		
	}
	
	public String getSQ(String name) {
		a=s.getData(name);
			String o= a.getSq();
			System.out.println("->"+o);
			 return o;
	}
	
	
	public String changePass(int acno,String newpass ) {
		String q=s.changePass( acno,newpass);
		return q;
	}
	public String  getUname(int acc) {
		a=s.acc(acno);
		String name=a.getName();
		return name;
		
	}
	
	
	public String transfer(int accA,int accB,double amt)
	{ System.out.println("in transfer");
		if(ac.validAccNo(accB)) {

			String a=Withdraw(accA,amt);

			s.updateBal(accB, (s.getBal(accB)+amt));

			 return a+" After transfer to "+accB+"";
		
	}return "Invalid Account no for transfer";

	}
	public int getAccno(String uname) {
		a=s.getData(uname);
		int acc=a.getAccNo();
		return acc;
		
		
	}
	public double getbal(String uname) {
		a=s.getData(uname);
		return a.getBal();
		
	}
	public void delete(String uname) {
		s.deleteAc(uname);
	}
	

	
	
	
	  public static void main(String[] args) {
	  AccountImpl a=new AccountImpl();
	  String s=a.getSQ("dd");
	  System.out.println(s);
	 
	  }
	 
	

}
