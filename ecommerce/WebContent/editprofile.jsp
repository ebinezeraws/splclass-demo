<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="userheader.jsp"%>

	<form action="updateprofile" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="id" value="${user.id}" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" value="${user.mobile}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Update" /></td>
			</tr>
		</table>

	</form>

</body>
</html>