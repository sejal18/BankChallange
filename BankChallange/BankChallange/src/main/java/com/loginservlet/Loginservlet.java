package com.loginservlet;

		

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.validatelogin.ValidateLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(Username);
		System.out.println(password);
		PrintWriter o=response.getWriter();		
		ValidateLogin v=new ValidateLogin();
		response.setContentType("text/html");
		boolean auth=v.authenticate(Username, password);
		
		
		 if(auth) { System.out.println("Authenticated");
		  request.setAttribute("username", Username);
		  request.setAttribute("password", password);
          //RequestDispatcher rd=request.getRequestDispatcher("MethodServlet");
         // rd.forward(request, response);
		  
		  //ServletContext context=set  

		  //response.sendRedirect("Methods.html"); 
		  HttpSession session=request.getSession();  
	        session.setAttribute("uname",Username);  
	        session.setAttribute("password",password);
			  response.sendRedirect("Methods.html"); 
			  

	  
		  
		  } else {
		  o.print("Invalid Cred!!!");
		  o.print("<a href=log.html>Go back</a>");
		 
		  
		  }
		 
	}

}
