package com.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(urlPatterns={"/SimpleServletPath"}, initParams={@WebInitParam(name="defaultUser", value="qiuju")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Simple Servlet Get Method");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("userName");
		out.println("Hello from Simple Servlet Get to "+ userName);
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		
		if((userName!=null)&&(userName!=""))
		{
		context.setAttribute("savedUserName", userName);
		}
		out.println("Request user name="+userName);
		out.println("Context user name="+(String)(context.getAttribute("savedUserName")));
		
		if(userName!=null)
		{
		session.setAttribute("savedUserName", userName);
		}
		out.println("Request user name="+userName);
		out.println("Session user name="+(String)(session.getAttribute("savedUserName")));
		
		out.println("Servlet init config="+this.getServletConfig().getInitParameter("defaultUser"));
		
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Simple Servlet Post Method");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");				
		String fullName=request.getParameter("fullName");
		String prof=request.getParameter("prof");
		String[] location=request.getParameterValues("location");
		out.println("Hello from Simple Servlet Post to "+ 
		"userName="+userName + "  fullName=" +fullName+"  profession="+prof);
		out.println("your are at "+ location.length+"locations");
		
		for(int i=0; i<location.length; i++)
		{
			out.println(location[i]);
		}
		
				
	}

}
