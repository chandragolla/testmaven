<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

DriverManager dm=null;
Connection con=null;
Statement stmt=null;

	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=dm.getConnection("jdbc:oracle:thin:@localhost:1521:orcl12","system","system");
	System.out.println("con---"+con);
	
	String Eid=request.getParameter("Empid");
	String Epwd=request.getParameter("password");
	stmt=con.createStatement();
	
	System.out.println("----1-----------");
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
%>

<%= Eid %>

<b>Last Name &nbsp;&nbsp;&nbsp; <%= Eid %> <br/>

<b>First Name &nbsp;&nbsp;&nbsp; <%= pass %> <br/>

<b>  </b><a href="UpdateEmpDetails"><b> Update Emp details</b></a>

<b>hello world </b>
<% 
	System.out.println("----3-----------"+id);

%>


</body>
</html>