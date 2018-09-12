package com.myfirstapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmpDetails
 */
@WebServlet("/UpdateEmpDetails")
public class UpdateEmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con =null;
		DriverManager dm=null;
		Statement stmt=null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=dm.getConnection("jdbc:oracle:thin:@localhost:1521:orcl12","system","system");
		System.out.println("con---"+con);
		
		String lname=request.getParameter("LastName");
		
		String sqlquery = "select * from employeeDetails where lastname='"+lname+"' ";
		System.out.println("----sqlquery-----------"+sqlquery);
		
		stmt=con.createStatement();
		
		ResultSet rs= stmt.executeQuery(sqlquery);
		
		rs.next();
		String last=rs.getString("lastname");
		String first=rs.getString("firstname");
		String gen=rs.getString("gender");
		String addr=rs.getString("address");
		
		PrintWriter out= response.getWriter();
		System.out.println("----end-----------"+addr);
		if(lname.trim().equals(last.trim())){
			
			
			
		out.println("<html><body>");
		out.println("<b>last Name:</b>&nbsp;&nbsp;" + last+"<br>" );
		out.println("<b>first Name:</b>&nbsp;&nbsp;" + first+"<br>"  );
		out.println("<b>gender:</b>&nbsp;&nbsp;" + gen +"<br>" );
		out.println("<b>address:</b>&nbsp;&nbsp;" + addr+"<br>"  );
		out.println("<b><a href=InsertEmpDetails.html>UpdateDetails</a><b>");
	
	
			
			
		}
		else{
			out.println("fail");
		}

		
		
	}catch(Exception e){
		
		e.printStackTrace();
		
	}
	}
}
