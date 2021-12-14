package com.registerservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accnovalidation.ValidAccNo;
import com.accountImpl.AccountImpl;


/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Username=request.getParameter("username");
		String password=request.getParameter("password");
		//Double amt=Double.parseDouble(request.getParameter("amt"));
		String sq=request.getParameter("sq");
		String hint=request.getParameter("hint");
		String type=request.getParameter("type");
		PrintWriter o=response.getWriter();

		response.setContentType("text/html");
        ValidAccNo v=new ValidAccNo();
        if(v.checkExist(Username)) {
        	AccountImpl h=new AccountImpl();	
    		String a=h.OpenAccount(type, Username, password, sq, hint);
    	
    		response.setContentType("text/html");
    		
    		o.println(a+"<a href =Welcome.html>Go Back</a>");
        	
        }else {
          
        	 o.println("<h2>Username Already Exist!! please choose different username</h2>");
             o.println("<h3><a href= Registration.html>Try Again?</a></h3>");
 
    		
        }
        
		


		
		//RegisterUser u=new RegisterUser();
		//u.insertData(Username, password,amt,"hh");
		
	//	response.sendRedirect("BankServices.html");
		
	}

}
