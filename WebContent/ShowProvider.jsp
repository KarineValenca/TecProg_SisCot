<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
	<c:when test="${param.locale eq 'pt_BR'}">
		<fmt:setLocale value="pt_BR" />
	</c:when>
	<c:otherwise>
		<fmt:setLocale value="en_US" />
	</c:otherwise>
</c:choose>
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
<fmt:setBundle basename="resouces.messages" var="msg"/>
<a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
	<c:import url="header.jsp" />
	<h3 class="row center">
		<fmt:message key="provider.provider" bundle="${msg}"/><b><%=request.getParameter("providerName")%></b>
	</h3>
	<br>
	<br>

	<div class="row">
		<div class="col s5 offset-s2">
			<fmt:message key="provider.provider_name" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerName")%></span><br>
			<br><fmt:message key="provider.provider_cnpj" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerCnpj")%></span><br>
			<br><fmt:message key="provider.provider_email" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerEmail")%></span><br>
			<br><fmt:message key="provider.provider_DDD" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerDdd")%></span><br>
			<br><fmt:message key="provider.provider_phone" bundle="${msg}"/><span
				class="blue-text text-darken-2"><%=request.getParameter("providerPhone")%></span><br>
			<br><br><fmt:message key="provider.zip" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerZip")%></span><br>
			<br><fmt:message key="provider.state" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerState")%></span><br>
			<br><fmt:message key="provider.city" bundle="${msg}"/><span class="blue-text text-darken-2"><%=request.getParameter("providerCity")%></span><br>
			<br><br><fmt:message key="provider.adress" bundle="${msg}"/><span
				class="blue-text text-darken-2"><%=request.getParameter("providerAdress")%></span><br>
			<br><fmt:message key="provider.authorization" bundle="${msg}"/><span
				class="blue-text text-darken-2"><%=request.getParameter("providerAuthorized")%></span><br>
			<br> 
		</div>
	</div>
</body>
</html>