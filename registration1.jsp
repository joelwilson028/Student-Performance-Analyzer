<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>SPA Sign Up Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="main">
	
	<div align = "center">
	<%
			String s = (String)request.getAttribute("status");
			if(s!=null)
			{
				if(s.equals("Success"))
				{
					out.print("<h3 style=color:green;> SignUp Successfull.</h3>");
				}
				else
				{
					if(s.equals("FailureEmail"))
					{
						out.print("<h3 style=color:red;> Signup Failed.Email already Exists! </h3>");
					}
					else if(s.equals("FailureUsername"))
					{
						out.print("<h3 style=color:red;> Signup Failed.Username already Exists! </h3>");
					}
					else
					{
						out.print("<h3 style=color:red;> Signup Failed.Email or Username already Exists! </h3>");
					}
				}
			}
			
		%>
		</div>

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="SignupServlet" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="uname"><i class="zmdi zmdi-account material-icons-name-outline"></i></label> <input
									type="text" name="uname" id="uname" placeholder="Username" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="pass" id="pass"
									placeholder="Password" />
							</div>
							<!--  <div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" />
							</div>-->
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login1.jsp" class="signup-image-link">I am already member</a>
							<a href="index1.jsp" class="signup-image-link">Home</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>