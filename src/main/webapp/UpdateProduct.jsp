<%@page import="impl.ProductDAOImpl"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<%
	int id = Integer.parseInt(request.getParameter("id"));

	ProductDAO cdao = new ProductDAOImpl();

	request.setAttribute("cat", cdao.getProduct(id));
%>

</head>

<c:import url="header.jsp"></c:import>
<body style="margin: auto; width: 80%;">

	<h1>Update Product</h1>

	<form action="UpdateProductToDB" method="post">

		<input type="hidden" value="${param.id}" name="id">

		<textarea name="category" placeholder="Enter Category"
			class="form-control"><c:if test="${not empty cat}">${cat.getCategory()}</c:if></textarea>
		<br>
		<textarea name="name" placeholder="Enter Name" class="form-control"><c:if
				test="${not empty cat}">${cat.getName()}</c:if></textarea>
		<br>
		<textarea name="quantity" placeholder="Enter Quantity"
			class="form-control"><c:if test="${not empty cat}">${cat.getQuantity()}</c:if></textarea>
		<br>
		<textarea name="price" placeholder="Enter Price" class="form-control"><c:if
				test="${not empty cat}">${cat.getPrice()}</c:if></textarea>
		<br>
		<textarea name="description" placeholder="Enter Description"
			class="form-control"><c:if test="${not empty cat}">${cat.getDescription()}</c:if></textarea>
		<br> <br> <input type="submit" value="Submit"
			class="btn btn-success">

	</form>


</body>
</html>