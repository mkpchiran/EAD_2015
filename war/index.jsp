<%@page import="com.ead.myproj.db.EMF"%>
<%@page import="com.ead.myproj.controller.UserJpaController"%>
<%@page import="com.ead.myproj.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BGE Pvt Ltd.</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css"
	type="text/css" />
</head>
<body>
	<%
		String message_error = "";
		if (request.getAttribute("message_error") == null) {
			message_error = "";
		} else {
			message_error = "<div class=\"alert alert-danger\">"
					+ request.getAttribute("message_error").toString()
					+ "</div>";
		}
		UserJpaController controller = new UserJpaController(EMF.get());

		String message_success = "";
		if (request.getAttribute("message_success") == null) {
			message_success = "";
		} else {
			message_success = "<div class=\"alert alert-success\">"
					+ request.getAttribute("message_success").toString()
					+ "</div>";
		}
	%>

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
					<li><p class="navbar-text">or</p></li>
					<li><a href="index.jsp">Sign in with Google</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4 well ">
				<legend>Sign up!</legend>

				<!--<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true"></button> -->
				<%=message_error%>
				<%=message_success%>

				<form accept-charset="UTF-8" role="form" method="post"
					action="login">
					<fieldset>

						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input id="login-username" type="text" class="form-control"
								name="username" value="" placeholder="username or email">
						</div>
						<div style="margin: 25px"></div>

						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
						</div>
						<div class="checkbox">
							<label> <input name="remember" type="checkbox"
								value="Remember Me"> Remember Me
							</label>
						</div>

						<input class="btn btn-lg btn-success btn-block" type="submit"
							value="Login">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>