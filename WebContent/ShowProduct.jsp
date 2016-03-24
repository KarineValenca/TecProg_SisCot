<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>SisCot</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="blue lighten-5">
	<c:import url="header.jsp" />
	<h3 class="row center">
		Produto <b><%=request.getParameter("productName")%></b>
	</h3>
	<br>
	<br>

	<div class="row">
		<div class="col s5 offset-s2">
			Nome do Produto: <span class="blue-text text-darken-2"><%=request.getParameter("productName")%></span><br>
			<br> <a
				href="/SisCot/DeleteProduct?productName=<%=request.getParameter("productName")%>">
				Deletar Produto</a> <br> <a
				href="/SisCot/UpdateProductView.jsp?productName=<%=request.getParameter("productName")%>
		">
				Alterar Produto</a>
		</div>
	</div>

</body>
</html>