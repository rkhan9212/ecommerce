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

	<h1>Add Image</h1>

	<form action="AddImageToDB" method="post" enctype="multipart/form-data">
		
		<input type="file" name="kaddu" class="form-control"> <br>
		
		<input type="submit" value="Submit" class="btn btn-success">

	</form>

	<img alt="" src="https://res-console.cloudinary.com/dkatvt5ae/thumbnails/v1/image/upload/v1540911035/c2FtcGxl/grid" class="img img-thumbnail" style="max-width: 400px;">
	<img alt="" src="https://res-console.cloudinary.com/dkatvt5ae/thumbnails/v1/image/upload/v1541074611/enppNWR2aTJvcG1weXVydnB0am4=/grid" class="img img-thumbnail" style="max-width: 400px;">


</body>
</html>