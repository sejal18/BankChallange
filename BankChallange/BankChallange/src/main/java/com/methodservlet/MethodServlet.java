package com.methodservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MethodServlet
 */
@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MethodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o=response.getWriter();
		 HttpSession session=request.getSession();  
	       String uname=(String) session.getAttribute("uname");
	  
		String choice=request.getParameter("choice");
		if (choice.equals("withdraw")) {
            response.sendRedirect("withdrawl.html");

		} else if (choice.equals("deposit")) {
            response.sendRedirect("deposite.html");
	    } else if (choice.equals("bal")) {
            response.sendRedirect("GetBal");
	    } else if (choice.equals("transfer")) {
            response.sendRedirect("Transfer.html");

          }else if (choice.equals("Delete")) {
              response.sendRedirect("Delete.html");

            }
	    
	
		
		//String uname=(String) request.getAttribute("Uname");
		o.print(choice+""+uname);
	}

}
