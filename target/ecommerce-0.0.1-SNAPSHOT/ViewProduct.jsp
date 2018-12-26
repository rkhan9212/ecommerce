<%@page import="impl.ProductDAOImpl"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>


<%
	ProductDAO pdao = new ProductDAOImpl();

	request.setAttribute("products", pdao.getProduct());
%>

</head>
<body>

<c:import url="header.jsp"></c:import>

	<table class="table table-striped">

		<thead>

			<tr>
				<td>Id</td>
				<td>Category</td>
				<td>Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>Description</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${products}" var="x">

				<tr>
					<td>${x.getId()}</td>
					<td>${x.getCategory()}</td>
					<td>${x.getName()}</td>
					<td>${x.getQuantity()}</td>
					<td>${x.getPrice()}</td>
					<td>${x.getDescription()}</td>

					<td><a href="UpdateProductFromDB?id=${x.getId()}"
						class="btn btn-success">Update</a></td>
					<td><a href="DeleteProductFromDB?id=${x.getId()}"
						class="btn btn-danger">Delete</a></td>

				</tr>

			</c:forEach>


		</tbody>

	</table>

</body>
</html>