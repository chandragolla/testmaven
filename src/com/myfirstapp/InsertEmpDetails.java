package com.myfirstapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertEmpDetails
 */
@WebServlet("/InsertEmpDetails")
public class InsertEmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("---Calling from EmpServ---");
		
		
		String empid = request.getParameter("Empid");
		
		
		System.out.println("--InsertEmpDetails servlet-empid-"+empid);
		
		Connection con =null;
		DriverManager dm=null;
		Statement stmt=null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=dm.getConnection("jdbc:oracle:thin:@localhost:1521:orcl12","system","system");
		System.out.println("con---"+con);
		
		String fname=request.getParameter("Empfname");
		String lname=request.getParameter("Emplname");
		String gen=request.getParameter("gender");
		String address=request.getParameter("Empadd");
		
		System.out.println("fname---"+fname);
		
		String ins="insert into employeeDetails values('"+fname+"','"+lname+"','"+gen+"','"+address+"')";
		stmt=con.createStatement();
		stmt.executeQuery(ins);
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		System.out.println("--InsertEmpDetails servlet-End-");
		}

}
