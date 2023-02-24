<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPA</title>
</head>
<link href="css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
<%@ include file = "LoginHeader.jsp" %>
<%
		response.addHeader("pragma", "no-cache");
		response.addHeader("cache-control", "no-store");
		response.addHeader("expire", "0");
%>
<body id="page-top">
<div align="center">
	<h2 style="text-align: center">Welcome Aboard</h2><br><br> 
		
		<!--  <form action="FileuploadServlet" method="post" enctype="multipart/form-data">-->
		
			<!--  Select a file to upload &nbsp;&nbsp;&nbsp;-->
		<!-- 	<input type="file" name="fileupload" >--> <!-- In this line of code , it is use to take single file for upload. -->
			<!--  <input type="file" name="file" multiple> * In this line of code , multiple is to take multiple files for upload.-->
		  <!--  	<button class="btn btn-success" type = "submit">Submit</button>
		
		  </form>-->

</div> 


</body>
</html>