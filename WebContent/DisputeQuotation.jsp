<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
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

	<h2 class="center">
		Relatório
		<%=session.getAttribute("userType")%></h2>

	<c:if test="${not empty listProducts}">
		<div class="row">
			<form action="DisputeQuotation" class="col s12">
				<div class="row">
					<div class="input-field col s4 offset-s4 ">
						<c:forEach items="${listProducts}" var="product">
							<div class="input-field">
								<input placeholder="R$" id="${product}" type="text"
									class="validate" name="${product}" value="0.0"> <label
									for="${product}"><span> ${product}</span></label> <br>
							</div>
						</c:forEach>
						<br>
						<button class="btn waves-effect waves-light" type="submit">
							Submit <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
				<input type="hidden" name="insert"
					value="<%=request.getParameter("quotationId")%>">
			</form>
		</div>
	</c:if>
	<c:if test="${empty listProducts}">
		<br>
		<br>
		<br>
		<h3 class="center">Não há produtos nesta cotação</h3>
	</c:if>
	<!-- ================================================
    Scripts
    ================================================ -->

	<!-- jQuery Library -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="js/materialize.js"></script>

</body>
</html>