package com.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Xml Servlet");
		response.setContentType("test/html");
//		String userName=request.getParameter("name");
		PrintWriter writer=response.getWriter();
//		writer.println("Hello: "+ userName +"!");
		writer.println("Hello user!");
				
	}
}
