<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
<link rel="stylesheet" href="css/app.css"></link>
</head>
<body>

</body>
	<h1>List of Customers</h1>
	
	<c:forEach var="customer" items="${Customers}">
		<h2>
			<c:out value="${customer.cId} ${customer.cName}"/>
		</h2>
		
		<h3>
			<c:out value="${customer.cName}'s Orders"/>
		</h3>
		
		<table>
			<tr>
				<th>Order ID</th>
				<th>Order Quantity</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>
			
			<c:forEach var="order" items="${customer.orders}">
				<tr>
					<td><c:out value="${order.oId}"/></td>
					<td><c:out value="${order.qty}"/></td>
					<td><c:out value="${order.prod.pId}"/></td>
					<td><c:out value="${order.prod.pDesc}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
	
	<a href="/">Home</a>
	<a href="/addCustomer">Add Customer</a>
	<a href="/showProducts">List Products</a>
	<a href="/showOrders">List Orders</a>
	<a href="/logout">Logout</a>
</html>