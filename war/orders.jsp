<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BGE Pvt Ltd. Orders List</title>
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
					<li><a href="add_item.jsp">Add Item</a></li>
					<li class="active"><a href="orders.jsp">Orders</a></li>
					<li><a href="profile.jsp">Profile</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">

					<li ><a href="home.jsp"> Home</a></li>
					<li><a href="inventory.jsp"><span class="badge pull-right">5</span>Inventory</a></li>
					<li><a href="add_item.jsp">Add Item</a></li>
					<li class="active"><a href="orders.jsp"><span class="badge pull-right">45</span>
							Orders</a></li>
					<li><a href="profile.jsp">Profile</a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="col-sm-8 col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object"
										src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="#">Product name</a>
										</h4>
										<h5 class="media-heading">
											by <a href="#">Brand name</a>
										</h5>
										<span>Status: </span><span class="text-success"><strong>In
												Stock</strong></span>
									</div>
								</div>
							</td>
							<td class="col-sm-1 col-md-1" style="text-align: center"><input
								type="email" class="form-control" id="exampleInputEmail1"
								value="3"></td>
							<td class="col-sm-1 col-md-1 text-center"><strong>$4.87</strong></td>
							<td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
							<td class="col-sm-1 col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button>
							</td>
						</tr>
						<tr>
							<td class="col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object"
										src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="#">Product name</a>
										</h4>
										<h5 class="media-heading">
											by <a href="#">Brand name</a>
										</h5>
										<span>Status: </span><span class="text-warning"><strong>Leaves
												warehouse in 2 - 3 weeks</strong></span>
									</div>
								</div>
							</td>
							<td class="col-md-1" style="text-align: center"><input
								type="email" class="form-control" id="exampleInputEmail1"
								value="2"></td>
							<td class="col-md-1 text-center"><strong>$4.99</strong></td>
							<td class="col-md-1 text-center"><strong>$9.98</strong></td>
							<td class="col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><h5>Subtotal</h5></td>
							<td class="text-right"><h5>
									<strong>$24.59</strong>
								</h5></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><h5>Estimated shipping</h5></td>
							<td class="text-right"><h5>
									<strong>$6.94</strong>
								</h5></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><h3>Total</h3></td>
							<td class="text-right"><h3>
									<strong>$31.53</strong>
								</h3></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<button type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Continue Shopping
								</button>
							</td>
							<td>
								<button type="button" class="btn btn-success">
									Checkout <span class="glyphicon glyphicon-play"></span>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
				
				
			</div>
		</div>


	</div>
	


</body>
</html>