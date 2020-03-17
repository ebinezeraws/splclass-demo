<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>

	<c:choose>
		<c:when test="${user!=null}">

			<%@include file="userheader.jsp"%>


			<form action="updateprofile" method="post">
				<table>
					<tr>
						<td><span class="errorMessage">${errorMessage}</span></td>
					</tr>
					<tr>
						<td><input type="hidden" name="id" value="${user.id}" /></td>
					</tr>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"
							value="${user.username}" /></td>
						<td><span class="errorMsgs">${errorMessages.usernameError}</span></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" value="${user.email}" /></td>
						<td><span class="errorMsgs">${errorMessages.emailError}</span></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="text" name="mobile" value="${user.mobile}" /></td>
						<td><span class="errorMsgs">${errorMessages.mobileError}</span></td>
					</tr>
					<tr>
						<td><input type="hidden" name="password"
							value="${user.password}"></td>
					</tr>
					<tr>
						<td><input type="hidden" name="confirmPassword"
							value="${user.password}"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Update" /></td>
					</tr>
				</table>

			</form>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>

</body>
</html>