<%@page import="com.ead.myproj.constants.EngineAttributes"%>
<%@page import="com.ead.myproj.db.EMF"%>
<%@page import="com.ead.myproj.controller.ItemJpaController"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ead.myproj.entity.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BGE Pvt Ltd. Inventory</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css"
	type="text/css" />
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
					<li class="active"><a href="inventory.jsp">Inventory</a></li>
					<li><a href="add_item.jsp">Add Item</a></li>
					<li><a href="orders.jsp">Orders</a></li>
					<li><a href="profile.jsp">Profile</a></li>
				</ul>
			</div>
		</div>
	</div>






	<%
		ItemJpaController controller = new ItemJpaController(EMF.get());
		List<Item> items = controller.findItemEntities();

		//Iterator iterator = items.iterator();
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">

					<li ><a href="home.jsp"> Home</a></li>
					<li class="active"><a href="inventory.jsp"><span class="badge pull-right">5</span>Inventory</a></li>
					<li><a href="add_item.jsp">Add Item</a></li>
					<li><a href="orders.jsp"><span class="badge pull-right">45</span>
							Orders</a></li>
					<li><a href="profile.jsp">Profile</a></li>
				</ul>
				<div style="padding: 25px; background: #dadada;">

					<form class="" method="post" action="additem">
						<legend>Categories</legend>
						<div class="form-group">
							Manufacture <select class="form-control" id="manufacture"
								name="manufacture">
								<%
									for (EngineAttributes.Manufacture manufacture : EngineAttributes.Manufacture
											.values()) {
										out.println("<option value=" + (manufacture.ordinal()) + ">"
												+ manufacture + "</option>");
									}
								%>
							</select>
						</div>
						<div class="form-group">
							Engine Capacity <select class="form-control" id="capacity"
								name="capacity">
								<%
									for (EngineAttributes.Capacity capacity : EngineAttributes.Capacity
											.values()) {
										out.println("<option value=" + (capacity.ordinal()) + ">"
												+ capacity + "</option>");
									}
								%>
							</select>
						</div>
						<div class="form-group">
							Fuel Type <select class="form-control" id="fuletype"
								name="fuletype">
								<%
									for (EngineAttributes.Fuletype fuletype : EngineAttributes.Fuletype
											.values()) {
										out.println("<option value=" + (fuletype.ordinal()) + ">"
												+ fuletype + "</option>");
									}
								%>
							</select>
						</div>
						<div class="form-group">
							Cylinders <select class="form-control" id="cylenders"
								name="cylinders">
								<%
									for (EngineAttributes.Cylenders cylenders : EngineAttributes.Cylenders
											.values()) {
										out.println("<option value=" + (cylenders.ordinal()) + ">"
												+ cylenders + "</option>");
									}
								%>
							</select>
						</div>
						<div class="form-group">
							Mounting Type <select class="form-control" id="mounting"
								name="mounting">
								<%
									for (EngineAttributes.MountingType mountingType : EngineAttributes.MountingType
											.values()) {
										out.println("<option value=" + (mountingType.ordinal()) + ">"
												+ mountingType + "</option>");
									}
								%>
							</select>
						</div>
						<div class="form-group">
							<input class="btn btn-default btn-block" type="submit"
								value="Search Item">
						</div>

					</form>
				</div>

			</div>
			<div class="col-md-9">
				<div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Model</th>
								<th>Capacity</th>
								<th>Fuel</th>
								<th>Cylinders</th>
								<th>Mounting</th>
								<th>Price</th>
								<th>Edit</th>
								<th>Remove</th>
							</tr>
						</thead>
						<tbody>
							<!-- Start of loop -->
							<%
								for (Item item : items) {
							%>
							<tr>
								<td class="col-sm-8 col-md-6">
									<div class="media">
										<a class="thumbnail pull-left" href="#"> <img
											class="media-object" src="images/item_placeholder.png"
											style="width: 64px; height: 64px;">
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												<%=item.getModel()%>
											</h4>
											<h5 class="media-heading">
												<%=EngineAttributes.Manufacture.values()[item
						.getManufacture()]%>
											</h5>
											<span>Status: </span><span class="label label-success"><strong><%=EngineAttributes.status[item.getStatus()]%></strong></span>
										</div>
									</div>
								</td>
								<td class="col-sm-1 col-md-1"><%=EngineAttributes.Capacity.values()[item.getCapacity()]%></td>
								<td class="col-sm-1 col-md-1"><%=EngineAttributes.Fuletype.values()[item.getFuel()]%></td>
								<td class="col-sm-1 col-md-1"><%=EngineAttributes.Cylenders.values()[item
						.getCylinders()]%></td>
								<td class="col-sm-1 col-md-1"><%=EngineAttributes.MountingType.values()[item
						.getMounting()]%></td>
								<td class="col-sm-1 col-md-1">$<%=item.getPrice()%></td>
								<td class="col-sm-1 col-md-1">
									<button type="button" class="btn btn-warning btn-sm">
										<span class="glyphicon glyphicon-edit"></span> Edit
									</button>
								</td>
								<td class="col-sm-1 col-md-1">
									<button type="button" class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-remove"></span> Remove
									</button>
								</td>
							</tr>

							<!--End of loop  -->
							<%
								}
							%>
						</tbody>
					</table>
					<ul class="pager">
						<li class="previous disabled"><a href="#">&larr; Older</a></li>
						<li class="next"><a href="#">Newer &rarr;</a></li>
					</ul>
				</div>

			</div>
		</div>


	</div>




</body>
</html>