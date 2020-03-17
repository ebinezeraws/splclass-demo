<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${user!=null}">

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

	</c:if>

	<c:if test="${user==null}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

</body>
</html>