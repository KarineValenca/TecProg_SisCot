<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import=" java.util.ArrayList"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Relatório da Cotação</title>

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

	<h2 class="center">
		<fmt:message key="report.title" bundle="${msg}"/>
		<%=session.getAttribute("userType")%></h2>


	<c:if test="${not empty listProducts}">
		<div class="row">
			<div class="col s3 offset-s1">
				<ul class="collection with-header">
					<li class="collection-header center"><h4><fmt:message key="report.report_products" bundle="${msg}"/></h4></li>

					<c:forEach items="${listProducts}" var="product">
						<li class="collection-item">${product}</li>
					</c:forEach>
				</ul>
			</div>

			<div class="col s4">
				<ul class="collection with-header">
					<li class="collection-header center"><h4><fmt:message key="report.report_providers" bundle="${msg}"/></h4></li>

					<c:forEach items="${listProviders}" var="provider">
						<li class="collection-item">${provider}</li>
					</c:forEach>
				</ul>
			</div>

			<div class="col s3">
				<ul class="collection with-header">
					<li class="collection-header center"><h4><fmt:message key="report.report_prices" bundle="${msg}"/></h4></li>

					<c:forEach items="${listPrices}" var="price">
						<li class="collection-item center">R$ ${price}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>



	<c:if test="${empty listProducts}">
		<br>
		<br>
		<br>
		<h3 class="center"><fmt:message key="report.report_message" bundle="${msg}"/></h3>
	</c:if>




</body>
</html>