package com.myfirstapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServ
 */
@WebServlet("/EmpServ")
public class EmpServ extends HttpServlet {
	
	boolean b;
	public static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DriverManager dm=null;
		Connection con=null;
		Statement stmt=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=dm.getConnection("jdbc:oracle:thin:@localhost:1521:orcl12","system","system");
			System.out.println("con---"+con);
			
			String Eid=request.getParameter("Empid");
			String Epwd=request.getParameter("password");
			stmt=con.createStatement();
			
			System.out.println("----1-----------");
			String sqlquery = "select * from emplogin where userid="+Eid+"";
			System.out.println("----sqlquery-----------"+sqlquery);
			ResultSet rs= stmt.executeQuery(sqlquery);
			
			System.out.println("----2-----------");
			rs.next();
		
			String id=rs.getString("userid");
			
			System.out.println("----Eid-----------"+Eid+"-======"+id);
			String pass=rs.getString("password");
			
			System.out.println("----Epwd-----------"+Epwd+"-======"+pass);

			System.out.println("----3-----------"+id);
			PrintWriter out= response.getWriter();
			
			System.out.println("----RequestDispatcher----EmpServ--start----");

			RequestDispatcher rd = request.getRequestDispatcher("InsertEmpDetails");
			
			rd.include(request, response);
			
			System.out.println("----Retrun to --EmpServ---");
			
			
			if(id.trim().equals(Eid.trim()) ){
				
				out.println("<b>login sucessfull<b>");
				out.println("<b><a href=InsertEmpDetails.html>InsertDetails</a><b>");
				out.println("<b><a href=UpdateEmpDetails.html>UpdateDetails</a><b>");
				
			}else{
				
				out.println("<b>login failed<b>");
				out.println("<b><a href=EmpDetails.html>Login</a><b>");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		PrintWriter out= response.getWriter();
		
		
		
		
	}

}
