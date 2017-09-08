<%@page
	import="com.tdn.Services.*, org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
</head>
<body style="background-color: #ececec">
	<div align="center"
		style="display: table; width: 100%; position: absolute; top: 30%">
		<h2 style="font-size: 60px; color: #6c3d7e">List of users</h2>
		<table border="1" width= "50%" style="border: 3px solid #8d8d8d; border-collapse: collapse">
			<tr>
				<td width="10%" style = "font-weight: bold">ID</td>
				<td width="30%" style = "font-weight: bold">Role</td>
				<td width="30%" style = "font-weight: bold">User Name</td>
				<td width="30%" style = "font-weight: bold">Password</td>
			</tr>
			${table}
		</table>

	</div>
</body>
</html>