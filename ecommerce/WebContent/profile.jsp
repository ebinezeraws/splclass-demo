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


	<table border="1">
		<tr>
			<td>Username</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td>${user.mobile}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="editprofile.jsp"><button>Edit</button></a></td>
		</tr>


	</table>



</body>
</html>