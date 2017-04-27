<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
	<h1>Add New Order</h1>
	
	<form:form modelAttribute="Order">
		<form>
			<table>
				<tr>
					<td><label>Customer ID: </label></td>
					<td><form:input path="cust"/></td>
					<td><form:errors path="cust"></form:errors></td>
				</tr>
				<tr>
					<td><label>Product ID: </label></td>
					<td><form:input path="prod"/></td>
					<td><form:errors path="prod"></form:errors></td>
				</tr>
				<tr>
					<td><label>Quantity: </label></td>
					<td><form:input path="qty"/></td>
					<td><form:errors path="qty"></form:errors></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
		</form>
	</form:form>
	
	<a href="/">Home</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showProducts">List Products</a>
</body>
</html>