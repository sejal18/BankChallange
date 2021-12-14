package com.getresetinputservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import com.accnovalidation.ValidAccNo;
import com.accountImpl.AccountImpl;
import com.mysql.cj.Session;

/**
 * Servlet implementation class GetResetIp
 */
@WebServlet("/GetResetIp")
public class GetResetIp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uname=request.getParameter("username");
    int accno=Integer.parseInt(request.getParameter("accno"));
    PrintWriter q=response.getWriter();
    response.setContentType("text/html");
   
   // request.setAttribute("nam", uname);
    //request.setAttribute("ac",accno);
    System.out.println(uname+""+accno);
    
	ValidAccNo v=new ValidAccNo();
	if(v.validAccNo(accno)) {
		if(v.validaccuname(uname, accno)) {
			AccountImpl p=new AccountImpl();
			String h=p.getSQ(uname);
		HttpSession session=request.getSession();
		session.setAttribute("nav", uname);
		session.setAttribute("ac", accno);
		q.print("<body bgcolor='pink'>");
		q.print("<h2>Your Security Question is</h2><br><br>");
		q.print("<h2>"+h+"</h2><br><br>");
		q.print("<h2><a href=Answerip.html>Click To Answer</a></h2><br>");
		q.print("<h3><a href=log.html>Go to Login page</a></h3><br>");
		q.print("</body>");
			
			
	}else {
		System.out.println("wrong");
	}
	}else {
		System.out.println("wrong1");
	}
		
		
	
	
	
	}

}
