package com.verifyans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accnovalidation.ValidAccNo;

/**
 * Servlet implementation class Verifyans
 */
@WebServlet("/Verifyans")
public class Verifyans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session=request.getSession();
	PrintWriter o=response.getWriter();
	int acc=(Integer) session.getAttribute("ac");
	String ans=request.getParameter("answer");
	
	System.out.println(ans+""+acc);
	ValidAccNo v= new ValidAccNo();
	
	if(v.verifyans(acc, ans)) {
      response.sendRedirect("ForgetPass.html");		
	}else{
        o.print("<h2>Hint Not Match!!</h2><br>");
        o.print("<h3><a href=log.html>Login again!</h3>");
        
	}
	
	}

}
