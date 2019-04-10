package com.jahadenglish.TestDb;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			//set up connection variables
		
			//get a connection to the database
		
			String user = "springstudent";
			String pass = "springstudent";
			
			String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
			
			 String driver = "com.mysql.cj.jdbc.Driver";
			
			try {
				PrintWriter out = response.getWriter();
				
				out.println("Connecting to the database: " + jdbcURL);
				
				Class.forName(driver);
				
				Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
				
				out.println("Connection sucessful");
				
				myConn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		
	}

}
