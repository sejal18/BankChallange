package com.accnovalidation;

import com.Account.Account;
import com.sqlquerry.SqQuerry;

public class ValidAccNo {
	static SqQuerry s=new SqQuerry();
	
	public boolean validAccNo(int accNo) {
		Account a=new Account();
		a=s.acc(accNo);
		if(a.getAccNo()==accNo) {
			return true;
		}return false;
		
 }
	
	public boolean verifyans(int acc,String hint) {
		Account a=new Account();
		a=s.acc(acc);
		String ans=a.getHint();
		if(ans.equals(hint)) {
			return true;
			
		}return false;
		
	}
	
	
	
	public boolean validaccuname(String uname,int acc)
	{
		Account a=new Account();
		a=s.acc(acc);
		String name=a.getName();
	    
		if(name.equals(uname)) {
			return true;
		}
		return false;
	}
	public boolean checkExist(String uname) {
		Account a =new Account();
		a=s.getData(uname);
		String p=a.getName();
		if(p!=null) {
         return false;
		}else {
			return true;
		}
		
	}
	
	
	
	

}
