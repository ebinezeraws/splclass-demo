<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@include file="header.jsp"%>

	<section id="content">
		<center>
			<span class="errorMsgs">${errorMessage}</span>
		</center>
		<div id="registration">
			<form action="registration" method="post" id="regform">
				<table>
					<tr>
						<td><label for="username">Username</label></td>
						<td><input type="text" name="username"
							value="${param.username}" /></td>
						<td class="errorMsgs">${errorMessages.usernameError}</td>
					</tr>
					<tr>
						<td><label for="email">Email</label></td>
						<td><input type="text" name="email" value="${param.email}" /></td>
						<td class="errorMsgs">${errorMessages.emailError}</td>
					</tr>
					<tr>
						<td><label for="mobile">Mobile</label></td>
						<td><input type="text" name="mobile" value="${param.mobile}" /></td>
						<td class="errorMsgs">${errorMessages.mobileError}</td>
					</tr>
					<tr>
						<td><label for="password">Password</label></td>
						<td><input type="password" name="password"
							value="${param.password}" /></td>
						<td class="errorMsgs">${errorMessages.passwordError}</td>
					</tr>
					<tr>
						<td><label for="confirmPassword">Confirm Password</label></td>
						<td><input type="password" name="confirmPassword"
							value="${param.confirmPassword}" /></td>
						<td class="errorMsgs">${errorMessages.confirmPasswordError}</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Register" /></td>
					</tr>
				</table>
			</form>
		</div>
	</section>

</body>
</html>