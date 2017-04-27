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
	<h1>Add New Customer</h1>
	
	<form:form modelAttribute="Customer">
		<form>
			<table>
				<tr>
					<td><label>Cust Name: </label></td>
					<td><form:input path="cName"/></td>
					<td><form:errors path="cName"></form:errors></td>
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
	<a href="/showOrders">List Orders</a>
	<a href="/showProducts">List Products</a>
</body>
</html>