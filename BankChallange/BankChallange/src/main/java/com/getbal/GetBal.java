package com.getbal;

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
 * Servlet implementation class GetBal
 */
@WebServlet("/GetBal")
public class GetBal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter e=response.getWriter();
	response.setContentType("text/html");
	HttpSession session=request.getSession();
	String sesi=(String) session.getAttribute("uname");
    
	AccountImpl i=new AccountImpl();
	double d=i.getbal(sesi);
	e.println("Your Bal is "+d+"<a href=Methods.html>Go Back</a>");
	}

}
