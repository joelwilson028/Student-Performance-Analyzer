<%@page import="dto.Studentform"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SPA</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<%@include file = "LoginHeader.jsp" %>
<body style = "background-color:#1abc9c">
<div class="container">
<center>
<div class="container" style="position: absolute;right: 400px;max-width: 510px;height : 740px;padding: 70px;background-color: white; color:black;">
		<h1>Update Page</h1>
		<%
			String s = (String)request.getAttribute("status");
			Studentform us =(Studentform)request.getAttribute("studentup");
			if(s!=null)
			{
				if(s.equals("Success"))
				{
					out.print("<h3 style=color:green;> Update Successfull.</h3>");
				}
				else
				{
					
						out.print("<h3 style=color:red;> Update Failed!");
				}
			}
			
		%>
		<br>
		<form action="UpdatestudentServlet" method = "post">
		
			Full Name : <input type = "text" name = "ufn" placeholder="Enter your Full Name" value="<%=us.getFullname()%>"> <br><br><br>
			Your EnrollNo : <input type = "text" name = "uenroll" placeholder ="Enter your EnrollNo " value="<%=us.getEnrollno() %>" readonly> <br><br><br>
			Your Email : <input type = "email" name = "uemail" placeholder ="Enter your Email " value="<%=us.getEmail() %>" readonly> <br><br><br>
			Mobile No  : <input type = "number" name = "umobile" placeholder ="Enter your Mobile No" value="<%=us.getMobileno()%>"> <br><br><br>
			Branch   : <input type = "text" name = "ubranch" placeholder="Enter your Branch" value="<%=us.getBranch()%>"> <br><br><br>
			Semester   : <input type = "number" name = "usem" placeholder ="Enter your Sem " value="<%=us.getSem()%>"><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
			<button class="btn btn-outline-primary" type = "submit">Update</button>
		
		</form>
		</div>
		</center>
		
</div>

</body>
</html>