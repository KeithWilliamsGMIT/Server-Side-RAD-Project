<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
	<h1>Error Creating the following Order</h1>
	
	<h2>${exception.message}</h2>
	
	<table>
		<tr>
			<th>Product ID</th>
			<th>Customer ID</th>
			<th>Quantity</th>
		</tr>
		
		<tr>
			<td>${exception.order.prod.pId}</td>
			<td>${exception.order.cust.cId}</td>
			<td>${exception.order.qty}</td>
		</tr>
	</table>
	
	<a href="/">Home</a>
	<a href="/addOrder">New Order</a>
	<a href="/showOrders">List Orders</a>
</body>
</html>