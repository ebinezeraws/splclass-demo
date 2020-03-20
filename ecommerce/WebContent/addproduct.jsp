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
	<%@include file="productmenu.jsp"%>


	<form action="addProduct" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><lable>Product Name</lable></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><lable>Product Price</lable></td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td><lable>Quantity</lable></td>
				<td><input type="text" name="quantity" /></td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td><textarea name="description" rows="5" cols="20"></textarea></td>
			</tr>
			<tr>
				<td><lable>Product Image</lable></td>
				<td><input type="file" name="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Product" /></td>
			</tr>
		</table>

	</form>

</body>
</html>