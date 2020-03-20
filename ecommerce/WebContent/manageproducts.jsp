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
	<%@include file="userheader.jsp"%>
	<%@include file="productmenu.jsp"%>



	<c:forEach items="${productList}" var="product">

		<div>
			<table>
				<tr>
					<td>Product Name</td>
					<td>${product.name}</td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td>${product.price}</td>
				</tr>
				<tr>
					<td>Product Quantity</td>
					<td>${product.quantity}</td>
				</tr>
				<tr>
					<td>Product Description</td>
					<td>${product.description}</td>
				</tr>
				<tr>
					<td>Product Image</td>
					<td><img src="./prodimages/${product.name}.jpg" width="200"
						height="200"></td>
				</tr>
			</table>
		</div>

	</c:forEach>


</body>
</html>