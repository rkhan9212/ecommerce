<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>

	<c:import url="header.jsp"></c:import>

	<h1>Add Product</h1>

	<form action="AddProductToDB" method="post">

		<input type="text" name="name" placeholder="Enter Product Name" class="form-control">
		<br>
		<input type="text" name="category" placeholder="Enter Product Category" class="form-control">
		<br>
		<input type="text" name="quantity" placeholder="Enter Product Quantity" class="form-control">
		<br>
		<input type="text" name="price" placeholder="Enter Product Price" class="form-control">

		<br>

		<textarea name="description" placeholder="Enter Product Description"
			class="form-control"></textarea>

		<br>
		<input type="submit" value="Submit" class="btn btn-success">

	</form>


</body>
</html>