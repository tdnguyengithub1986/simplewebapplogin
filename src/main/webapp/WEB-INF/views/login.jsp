<html>

<body style="background-color: #a4f2df">
	<div align="center" style="display:table; width:100%;position:absolute; top:30%">
		<h2 style="font-size: 60px; color: #6c3d7e">Please login!</h2>
		<p>
			<font color="red">${errorMessage}</font>
		</p>

		<form method="post" action="/loginStatus"
			style="vertical-align: middle">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" style="background-color:#fef2cf; width: 350px; font-size: 20px"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" style="background-color:#fef2cf; width: 350px; font-size: 20px"></td>
				</tr>
				<tr><td></td><td></td></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" style="background-color:#6986b6; border-color:#a9bad5 ;color:#10213c; float: right; width:80px; font-size: 20px"></td>
				</tr>
				<tr>
					<td></td>
					<td style="float:right"><p>Or if you have not yet got an account, please <a href="signuppage">sign up!</a></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
