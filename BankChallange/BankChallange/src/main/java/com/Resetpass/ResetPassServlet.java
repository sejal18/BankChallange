package com.Resetpass;

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
 * Servlet implementation class ResetPassServlet
 */
@WebServlet("/ResetPassServlet")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter p=response.getWriter();
      response.setContentType("text/html");
       AccountImpl a=new AccountImpl();
     HttpSession session=request.getSession();
     int acno=(Integer)session.getAttribute("ac");
	String password=request.getParameter("password");

      String o= a.changePass(acno, password);
      p.print("<h2>"+o+"</h2>");
      p.print("<h2><a href=log.html>Go to login page</h2>");

      
	  
	}

}
