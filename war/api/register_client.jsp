<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Company Registration</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="../bootstrap-theme.css" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap-theme.min.css" type="text/css" />
</head>

<body>

<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4 well ">
				<legend>Sign up!</legend>
				<form action="client_register" method="post" class="form" role="form">
					<input class="form-control" name="companyname" placeholder="Company Name" /> <br>
					<input class="form-control" name="username" placeholder="Username" /> <br>
					<input class="form-control" name="email" placeholder="Email" type="email" /> <br>
					<input class="form-control" name="password" placeholder="Password" type="password" /><br>
					<input class="form-control" name="password2" placeholder="Confirm Password" type="password" /> <br>
					<input class="form-control" name="phoneno" placeholder="Phone Number" /> <br>
					<input class="form-control" name="address" placeholder="Address" /> <br>
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