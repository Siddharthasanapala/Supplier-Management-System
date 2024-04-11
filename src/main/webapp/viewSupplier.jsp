<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supplier Table</title>
<style>
body {
	font-family: Arial, sans-serif;
}

a {
	justify-content: center;
	align-items: center;
	margin-top: 10px;
	padding: 8px 12px;
	border-radius: 5px;
	border: 1px solid navy;
	background-color: rgba(5, 30, 255, 0.1);
	font-size: 16px;
}

a:hover {
	background-color: rgba(10, 250, 20, 0.6);
}

table {
	width: 80%;
	margin: 0 auto;
	border-collapse: collapse;
}

th, td {
	padding: 12px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<!--  	<form action="<%= request.getContextPath()%>/ViewSupplierServlet" method="get">
	-->
	<%@ page import="javax.servlet.http.HttpServletRequest" %>
	<%@ page import="javax.servlet.http.HttpSession" %>
	<%
    HttpSession ses = request.getSession();
    String rollnum = (String) ses.getAttribute("rollnum");
    if (rollnum == null) {
        response.sendRedirect("login.html");
    }
	%>
	<h2 style="text-align: center;">Supplier Table</h2>
	<table>
		<tr>
			<th>Supplier ID</th>
			<th>Name</th>
			<th>Contact Person</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${sessionScope.supplierList}" var="supplier">
			<tr>
				<td>${supplier.supplier_id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.contact_person}</td>
				<td>${supplier.email}</td>
				<td>${supplier.phone_number}</td>
				<td>${supplier.address}</td>
			</tr>
		</c:forEach>
	</table>
	<center>
	<table>
		<tr>
			<br>
			<br>
			<br>
			<a href="home.html">Return Home!</a>
		</tr>
	</table>
	</center>
</body>
</html>
