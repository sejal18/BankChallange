package com.transferservelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accountImpl.AccountImpl;

/**
 * Servlet implementation class TransferMet
 */
@WebServlet("/TransferMet")
public class TransferMet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
		  
        PrintWriter w=response.getWriter();
        response.setContentType("text/html");
		AccountImpl s=new AccountImpl();
		 HttpSession session=request.getSession(); 
			String sesi=(String) session.getAttribute("uname");
			
		 double amt=Double.parseDouble(request.getParameter("amt")); 
		 int acca=s.getAccno(sesi); 
		 int accb=Integer.parseInt(request.getParameter("accno"));
		// System.out.println("uname->"+s+""+amt+"accA->"+acca+""+accb);
		//System.out.println(sesi+""+acca+""+accb+""+amt);
		String p=s.transfer(acca,accb,amt);
		w.print(p+"<a href=Methods.html>Go Back</a");
		
		
		
		//AccountImpl s=new AccountImpl();
	}

}
