<html>
<body>
	<h2>Please login!</h2>
	<p><font color="red">${errorMessage}</font></p>
	<form method= "post" action="/login">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name = "userName"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name ="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value = "Login"></td>
			</tr>
				
		</table>
	</form>
</body>
</html>
