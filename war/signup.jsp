<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css" />
</head>
<body>
	<div class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BGE Pvt Ltd.</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><p class="navbar-text">Not a Member?</p></li>
					<li><a href="signup.jsp">Create an Account</a></li>
					<li><a href="index.jsp">Sign in with Google</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%
		String message = "";
		if (request.getAttribute("message_error") == null) {
			message = "";
		} else {
			message = request.getAttribute("message_error").toString();
		}
	%>

<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4 well ">
				<legend>Sign up!</legend>
				<form action="signup" method="post" class="form" role="form">
					<input class="form-control" name="fullname" placeholder="Your Full Name" /> <br>
					<input class="form-control" name="username" placeholder="Your Username" /> <br>
					<input class="form-control" name="email" placeholder="Your Email" type="email" /> <br>
					<input class="form-control" name="password1" placeholder="Password" type="password" /><br>
					<input class="form-control" name="password2" placeholder="Confirm Password" type="password" /> <br>
					<input class="form-control" name="phoneno" placeholder="Your Phone Number" /> <br>
					<input class="form-control" name="address" placeholder="Your Address" /> <br>
					<div class="form-group">
						<label for="exampleInputFile" class="col-xs-6 .col-sm-3" >File input</label>
						<input type="file" id="exampleInputFile">
						<img src="" width="100px" height="100px" class="img-thumbnail">
					</div>
					<input type="checkbox" name="agreed">  <label> I agree with terms
					and conditions</label>
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Sign up</button>
					</form>
				</div>
			</div>
		</div>

</body>
</html>