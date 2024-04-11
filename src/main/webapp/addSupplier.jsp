<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: rgba(5, 30, 255, 0.1);
}

.container {
    background-color: rgba(130, 95, 255, 0.2);
    border: 3px solid navy;
    padding: 20px;
    border-radius: 10px;
}

form {
    text-align: center;
}

input[type="text"],
input[type="submit"],
a {
    margin-top: 10px;
    padding: 8px 12px;
    border-radius: 5px;
    border: 1px solid navy;
    background-color: #f0f0f0;
    font-size: 16px;
}

input[type="submit"] {
    background-color: navy;
    color: white;
    cursor: pointer;
}
input[type="submit"]:hover {
    background-color: red;
}

</style>
</head>
<body>
	<%@ page import="javax.servlet.http.HttpServletRequest" %>
	<%@ page import="javax.servlet.http.HttpSession" %>
	<%
    HttpSession Session = request.getSession();
    String rollnum = (String) Session.getAttribute("rollnum");
    if (rollnum == null) {
        response.sendRedirect("login.html");
    }
	%>

	<div class="container">
	<form action="<%= request.getContextPath()%>/AddSupplierServlet" method="get">
	<!--  
	<form action="AddSupplierServlet" method="post">
	-->
		<table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Contact Person :</td>
				<td><input type="text" name="contact_person"></td>
			</tr>
			<tr>
				<td>Email ID :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><input type="text" name="phone_number"></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr><td colspan="2"><br></td></tr>
			<tr>
				<td colspan="2"><input type="submit" name="Register" value="Add Supplier"></td>
			</tr>
			<tr><td colspan="2"><br></td></tr>
			<tr><td colspan="2"><br></td></tr>
			<tr><td colspan="2"><a href="home.html">Return Home!</a></td></tr>
		</table>
	</form>
	</div>
</body>
</html>