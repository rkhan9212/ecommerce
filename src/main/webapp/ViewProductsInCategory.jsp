<%@page import="dao.ProductDAO"%>
<%@page import="impl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ProductDAO pdao = new ProductDAOImpl();

	request.setAttribute("productList", pdao.getProduct( request.getParameter("catName") ));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>${productList}</h1>

</body>
</html>