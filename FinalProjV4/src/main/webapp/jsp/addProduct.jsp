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
	<h2>Add product</h2>
	
	<form:form modelAttribute="Product">
		<form>
			<table>
				<tr>
					<td><label>Product Description: </label></td>
					<td><form:input path="pDesc"></form:input></td>
				</tr>
				<tr>
					<td><label>Quantity In Stock: </label></td>
					<td><form:input path="qtyInStock"/></td>
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
	<a href="/listOrders">List Orders</a>
	<a href="/listProducts">List Products</a>
</body>
</html>