package com.depositservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Account.Account;
import com.accountImpl.AccountImpl;
import com.sqlquerry.SqQuerry;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   PrintWriter w=response.getWriter();
	    response.setContentType("text/html");
		HttpSession session=request.getSession();
	//	String username=(String) session.getAttribute("username");
		String sesi=(String) session.getAttribute("uname");
		Double amt=Double.parseDouble(request.getParameter("amt"));
		System.out.println(sesi+"joyd");
		AccountImpl  s=new AccountImpl ();
		SqQuerry e=new SqQuerry();
		Account p=e.getData(sesi);
		int acno=p.getAccNo();
		System.out.println(acno);
		String o=s.deposit(acno,amt);
		w.print(o+"<a href=Methods.html>Go Back</a>");
		
		
		
	}
}
