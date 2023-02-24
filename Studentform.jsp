<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPA</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<%@include file = "LoginHeader.jsp" %>

<body>
 <br>
 <div class="main">
 <%
 String s = (String)request.getAttribute("status");
	if(s!=null)
	{
		if(s.equals("Success"))
		{
			out.print("<h3 style=color:green;> Student details uploaded successfull.</h3>");
		}
		else
		{
			if(s.equals("FailureEmail"))
			{
				out.print("<h3 style=color:red;> Student details not uploaded.Email already exists! </h3>");
			}
			else if(s.equals("FailureEnroll"))
			{
				out.print("<h3 style=color:red;> Student details not uploaded.Enrollmentno already exists! </h3>");
			}
			else
			{
				out.print("<h3 style=color:red;> Student details not uploaded.Email and Enrollmentno already exists! </h3>");
			}
		}
	}
			
		%>
 <div align = "center">
 
 <form action="StudentformServlet" method="post">
 
  <div class="form-group">
    <label for="exampleInputEmail1">Full Name of Student</label>
    <input type="text" class="form-control" name="sname" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Name" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Enrollment Number</label>
    <input type="text" name="senrollno" class="form-control" id="exampleInputPassword1" placeholder="Enter Enroll No" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Email</label>
    <input type="email" name="semail" class="form-control" id="exampleInputPassword1" placeholder="Enter Email" >
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Mobile No</label>
    <input type="number" name="smobile" maxlength="10" class="form-control" id="exampleInputPassword1" placeholder="Enter Mobile No" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Branch</label>
    <input type="text" name="sbranch" class="form-control" id="exampleInputPassword1" placeholder="Enter Branch" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Semester</label>
    <input type="number" name="ssem" maxlength="8" class="form-control" id="exampleInputPassword1" placeholder="Enter Semester" required>
  </div>
  <br><br>
  
  <button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;&nbsp;<button type="reset" class="btn btn-danger">Clear</button>
</form>

 </div>
 </div>
 
 
</body>
</html>