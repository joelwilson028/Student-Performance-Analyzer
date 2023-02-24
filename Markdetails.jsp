<%@page import="java.util.ArrayList"%>
<%@page import = "dto.Marksupload" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="PL1.jpg">
<title>SPA</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<%@include file = "LoginHeader.jsp" %>
<%
		response.addHeader("pragma", "no-cache");
		response.addHeader("cache-control", "no-store");
		response.addHeader("expire", "0");
%>
<body>
<div class="container">
		<br>
		
		<center><h1 style="background-color:#37474F;color:white;padding:10px;">Student Marks</h1></center><br>
	
		<%
				String s = (String)request.getAttribute("status");
				ArrayList<Marksupload> list = (ArrayList<Marksupload>) request.getAttribute("LIST");
			
		%>
		 <% if(s!=null)
			{
				out.println("<h3 style= color:blue;>"+s+"</h3>");
			}
			%>
			
		<% if(list!=null){ %>
		
		<h3><a href="Marks.jsp"> Add Marks </a></h3>
		<br>
		<table class="table" border="8" style="border-color:grey;">
		<thead class="table-dark">
		<th>Full Name</th>
		<th>Enrollment No</th>
		<th>Subject</th>
		<th>Marks Obtained</th>
		<th>Total Marks</th>
		
		<th>Update</th>
		<th>Delete</th>
		
		<% for(Marksupload sf:list){ %>
		<tr class="table-light">
				<td><%=sf.getName() %></td>
				<td><%=sf.getEnrollno() %></td>
				<td><%=sf.getSubject()%></td>
				<td><%=sf.getMarksob() %></td>
				<td><%=sf.getTotalmarks() %></td>
				
				
				<td><a href="UpdatestudentServlet?enrollno=<%=sf.getEnrollno() %>" class="btn btn-primary">Update</a></td>
				<td><a href="DeletestudentServlet?enrollno=<%=sf.getEnrollno() %>" class="btn btn-danger" onclick="return confirm('Are you sure to DELETE this record?')">Delete</a></td>
		</tr>
		<%} %>
		<%} %>
		</table>
</div>
</body>
</html>