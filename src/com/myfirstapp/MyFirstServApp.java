package com.myfirstapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServApp
 */
@WebServlet("/MyFirstServApp")
public class MyFirstServApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DriverManager dm=null;
	Connection con=null;
	Statement stmt=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	  try{
			System.out.println("----------connecting----");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		con =dm.getConnection("jdbc:oracle:thin:@localhost:1521:orcl12","system","system");
		
		System.out.println("----------connected----"+con);
		String ID= request.getParameter("EmpID");
		String pwd=request.getParameter("password");
		String brh=request.getParameter("Branch");
		String age=request.getParameter("age");
		
		
		String ins="insert into emplogin values("+ID+",'"+pwd+"','"+brh+"')";
		String upt="update emplogin set userid=1234 where userid=123";
		
	  stmt=con.createStatement();
	  stmt.execute(upt);
	  
	  PrintWriter out= response.getWriter();
	  out.println("<b>inserted</b>");
	  System.out.println("-inserted----");
	  }catch(Exception e){
		  
		  e.printStackTrace();
		  
	  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
