<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@include file="header.jsp"%>

	<section id="login-section">
		${errorMessage}
		<form action="login" method="post" name="loginform">
			<table>
				<tr>
					<td><label for="username">Username</label></td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>

		</form>

	</section>


</body>
</html>