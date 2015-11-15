<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ead.myproj.constants.EngineAttributes"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BGE Pvt Ltd. Add Item</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
</head>
<body>
	<div class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BGE Pvt Ltd.</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="inventory.jsp">Inventory</a></li>
					<li class="active"><a href="add_item.jsp">Add Item</a></li>
					<li><a href="orders.jsp">Orders</a></li>
					<li><a href="profile.jsp">Profile</a></li>
				</ul>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">

					<li><a href="home.jsp"> Home</a></li>
					<li><a href="inventory.jsp"><span class="badge pull-right">5</span>Inventory</a></li>
					<li class="active"><a href="add_item.jsp">Add Item</a></li>
					<li><a href="orders.jsp"><span class="badge pull-right">45</span>
							Orders</a></li>
					<li><a href="profile.jsp">Profile</a></li>
				</ul>
			</div>
			<div class="col-md-9">

				<div class="row">
					<div class="col-md-7" ">
						<form class="form-horizontal" method="post" action="additem">
							<table>
								<tr>
									<td>Engine Model</td>
									<td><input class="form-control" type="text" name="model" /></td>
								</tr>
								<tr>
									<td>Manufacture</td>
									<td><select class="form-control" id="manufacture"
										name="manufacture">
											<%
												for (EngineAttributes.Manufacture manufacture : EngineAttributes.Manufacture
														.values()) {
													out.println("<option value=" + (manufacture.ordinal()) + ">"
															+ manufacture + "</option>");
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td>Cubic capacity</td>
									<td><select class="form-control" id="capacity"
										name="capacity">
											<%
												for (EngineAttributes.Capacity capacity : EngineAttributes.Capacity
														.values()) {
													out.println("<option value=" + (capacity.ordinal()) + ">"
															+ capacity + "</option>");
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td>Fule type</td>
									<td><select class="form-control" id="fuletype"
										name="fuletype">
											<%
												for (EngineAttributes.Fuletype fuletype : EngineAttributes.Fuletype
														.values()) {
													out.println("<option value=" + (fuletype.ordinal()) + ">"
															+ fuletype + "</option>");
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td>Cylinders</td>
									<td><select class="form-control" id="cylenders"
										name="cylinders">
											<%
												for (EngineAttributes.Cylenders cylenders : EngineAttributes.Cylenders
														.values()) {
													out.println("<option value=" + (cylenders.ordinal()) + ">"
															+ cylenders + "</option>");
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td>Mounting type</td>
									<td><select class="form-control" id="mounting"
										name="mounting">
											<%
												for (EngineAttributes.MountingType mountingType : EngineAttributes.MountingType
														.values()) {
													out.println("<option value=" + (mountingType.ordinal()) + ">"
															+ mountingType + "</option>");
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td>Price</td>
									<td><input class="form-control" type="text" name="price"
										value="0.00" /></td>
								</tr>
								<tr>
									<td>Available Quantity</td>
									<td><input class="form-control" type="text"
										name="quantity" value="0" /></td>
								</tr>
								<tr>
									<td>Discription</td>
									<td><textarea class="form-control" name="discription"
											id="" cols="40" rows="5"></textarea>
								</tr>

							</table>
							<input class="btn btn-default" type="submit" value="SignUp">
						</form>
					</div>
					<div class="col-md-5" ">
						Upload Photo <img src="" width="100px" height="100px" />
					</div>


				</div>
			</div>
		</div>


	</div>


</body>
</html>