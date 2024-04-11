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
		
	<div class="container">
		<h1>Supplier Register Form</h1><br>
		<form action="<%= request.getContextPath()%>/Register" method="get">
			<table style="width:80%">
				<tr>
					<td>Supplier ID</td>
					<td><input type="text" name="name" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" required/></td>
				</tr>
			</table>
			<input type="submit" name="Register" value="Register"/>
		</form>
	</div>
</body>
</html>