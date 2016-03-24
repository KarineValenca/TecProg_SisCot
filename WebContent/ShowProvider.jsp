<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		Fornecedor <b><%=request.getParameter("providerName")%></b>
	</h3>
	<br>
	<br>

	<div class="row">
		<div class="col s5 offset-s2">
			Nome do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerName")%></span><br>
			<br> CNPJ do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerCnpj")%></span><br>
			<br> Email do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerEmail")%></span><br>
			<br> DDD do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerDdd")%></span><br>
			<br> Telefone do Fornecedor: <span
				class="blue-text text-darken-2"><%=request.getParameter("providerPhone")%></span><br>
			<br> CEP do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerZip")%></span><br>
			<br> Estado do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerState")%></span><br>
			<br> Cidade do Fornecedor: <span class="blue-text text-darken-2"><%=request.getParameter("providerCity")%></span><br>
			<br> Endereço do Fornecedor: <span
				class="blue-text text-darken-2"><%=request.getParameter("providerAdress")%></span><br>
			<br> Autorização do Fornecedor: <span
				class="blue-text text-darken-2"><%=request.getParameter("providerAuthorized")%></span><br>
			<br> 
		</div>
	</div>
</body>
</html>