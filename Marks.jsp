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
					out.print("<small><h3 style=color:green;> Marks uploaded successfully.</h3></small>");
				}
				else
				{
					if(s.equals("Marksfail"))
					{
						out.print("<small><h3 style=color:red;> Total Marks should be greater than marks obtained!</h3></small>");
					}
					else
					{
						out.print("<small><h3 style=color:red;> Marks not uploaded.</h3></small>");
					}
				}
			}
			
		%>
 <div align = "center">
 
 <form action="MarksServlet" method="post">
 
  <div class="form-group">
    <label for="exampleInputEmail1">Full Name of Student</label>
    <input type="text" class="form-control" name="fname" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Name" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Enrollment Number</label>
    <input type="text" name="enrollno" class="form-control" id="exampleInputPassword1" placeholder="Enter Enroll No" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Subject</label>
    <input type="text" name="sub" class="form-control" id="exampleInputPassword1" placeholder="Enter Subject" >
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Marks Obtained</label>
    <input type="number" name="marksob" class="form-control" id="exampleInputPassword1" placeholder="Enter marks obtained" required>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Total Marks</label>
    <input type="number" name="totalmarks" class="form-control" id="exampleInputPassword1" placeholder="Enter total marks" required>
  </div>
  <br><br>
  
  <button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;&nbsp;<button type="reset" class="btn btn-danger">Clear</button>
</form>

 </div>
 </div>
 
 
</body>
</html>