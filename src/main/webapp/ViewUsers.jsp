<%@page import="impl.UsersDAOImpl"%>
<%@page import="dao.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<c:import url="header.jsp"></c:import>


<%
	UsersDAO cdao = new UsersDAOImpl();


	request.setAttribute("list", cdao.getUsers());
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>View Users:</h1>
	<h1>${errorMap}</h1>

	<table class="table table-striped">

		<thead>

			<tr>
				<td>Id</td>
				<td>UserName</td>
				<td>Password</td>
				<td>Email</td>
				<td>Phone number</td>
				<td>Address</td>
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${list}" var="x">

				<tr>
					<td>${x.getId()}</td>
					<td>${x.getUsername()}</td>
					<td>${x.getPassword()}</td>
					<td>${x.getEmail()}</td>
					<td>${x.getPhoneNo()}</td>
					<td>${x.getAddress()}</td>
					
					
					 <td><a href="DeleteUsersFromDB?id=${x.getId()}"
					     class ="btn btn-danger"> delete</a></td>
					    
				</tr>

			</c:forEach>


		</tbody>

	</table>

</body>
</html>