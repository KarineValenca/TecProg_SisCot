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
<body class="blue lighten-5	">
<fmt:setBundle basename="resouces.messages" var="msg"/>
<a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
	<c:import url="header.jsp" />
	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h1 class="header center orange-text"><fmt:message key="index.title" bundle="${msg}"/></h1>
			<div class="row center">
				<h5 class="header col s12 light"><fmt:message key="index.system_description" bundle="${msg}"/></h5>
			</div>
			<div class="row center">

				<%
					if (session.getAttribute("user") == null) {
				%>

				<a href="/SisCot/login.jsp" id="download-button"
					class="btn-large waves-effect waves-light orange"><fmt:message key="login.login" bundle="${msg}"/></a>
				<%
					}
				%>
			</div>
			<br> <br>

		</div>
	</div>


	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">flash_on</i>
						</h2>
						<h5 class="center"><fmt:message key="index.agile_negociation" bundle="${msg}"/></h5>

						<p class="light"><fmt:message key="index.agile_negociation_description" bundle="${msg}"/></p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center"><fmt:message key="index.competitiveness" bundle="${msg}"/></h5>

						<p class="light"><fmt:message key="index.competitiveness_description" bundle="${msg}"/></p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">settings</i>
						</h2>
						<h5 class="center"><fmt:message key="index.access_facility" bundle="${msg}"/></h5>

						<p class="light"><fmt:message key="index.access_facility_description" bundle="${msg}"/></p>
					</div>
				</div>
			</div>

		</div>
		<br> <br>

		<div class="section"></div>
	</div>

	<footer class="page-footer orange">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">BMGWA Developers</h5>
				<p class="grey-text text-lighten-4"><fmt:message key="index.developers_description" bundle="${msg}"/></p>


			</div>
			<div class="col l3 s12">
				<h5 class="white-text"><fmt:message key="index.settings" bundle="${msg}"/></h5>
				<ul>
					<li><a class="white-text"
						href="https://github.com/BMGWA/SisCot"><fmt:message key="index.application_code" bundle="${msg}"/></a></li>
					<li><a class="white-text"
						href="https://github.com/BMGWA/SisCot/wiki"><fmt:message key="index.documentation" bundle="${msg}"/></a></li>
				</ul>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">
					<fmt:message key="index.contact" bundle="${msg}" />
				</h5>
				<ul>
					<li><a class="white-text" href="#!">Iago Rodrigues</a></li>
					<li><a class="white-text" href="#!">Jonathan Rufino</a></li>
					<li><a class="white-text" href="#!">Tiago Assunção</a></li>
				</ul>

			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">
			Made by <a class="orange-text text-lighten-3"
				href="http://materializecss.com">Materialize</a>
		</div>
	</div>
	</footer>


	<!-- jQuery Library -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>
