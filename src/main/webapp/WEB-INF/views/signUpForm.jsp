<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Form</title>
</head>
<body style="background-color: #ececec">
	<div
		style="display: table; width: 100%; position: absolute; top: 30%; left: 20%">
		<p style="font-size: 40px; color: #6c3d7e">Please choose your user name and password!<p>
		<form method="post" action="/signup">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName"></td>
					<td style="width:100px"></td>
					${userNameSuggestion}
				</tr>
				<tr style="height:5px"></tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
					<td></td>
					${passwordSuggestion}
					<td style="color:red; width:500px"><form:errors path="newUser.password"/></td>
				</tr>
				<tr style="height:5px"></tr>
				<tr>
					<td>Confirm password</td>
					<td><input type="text" name="confirmedPassword"></td>
					<td></td>
					${confirmPasswordSuggestion}
				</tr>
				<tr style="height:5px"></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" style="float:right"/></td>
				</tr>

			</table>

		</form>
	</div>
</body>
</html>