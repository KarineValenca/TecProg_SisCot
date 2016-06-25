<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
	<c:when test="${param.locale eq 'pt_BR'}">
		<fmt:setLocale value="pt_BR"/>
	</c:when>
	<c:otherwise>
		<fmt:setLocale value="en_US"/>
 	</c:otherwise>
</c:choose>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1.0" />
		<title>Cadastrar Fornecedor</title>
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
		<c:import url="header.jsp" />
		<br><br>
		<a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
        <br>
		<div class="row center">
			<h1><fmt:message key="IncludeProviderView.title" bundle="${msg}"/></h1>
		</div>
		<div class="container">
			<form class="pure-form pure-form-aligned" action="IncludeProvider"
				method="POST" class="center">
				<fieldset>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="cnpj">
								CNPJ
							</label> 
							<input id="cnpj" name="cnpj" type="text" placeholder="
							<fmt:message key="IncludeProviderView.cnpj" bundle="${msg}"/>">
						</div>
						<div class="pure-control-group col s6">
							<label for="phone">
								<fmt:message key="IncludeProviderView.phone" bundle="${msg}"/>
							</label>
							<input id="phone" name="phone" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informPhone" bundle="${msg}"/>">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="name">
								<fmt:message key="IncludeProviderView.name" bundle="${msg}"/>
							</label>
							<input id="name" name="name" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informName" bundle="${msg}"/>">
						</div>
						<div class="pure-control-group col s6">
							<label for="adress">
								<fmt:message key="IncludeProviderView.adress" bundle="${msg}"/>
							</label> 
							<input id="adress" name="adress" type="text" placeholder="
								<fmt:message key="IncludeProviderView.informAdress" bundle="${msg}"/>">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="email">
								Email
							</label> 
							<input id="email" name="email" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informEmail" bundle="${msg}"/>">
						</div>
						<div class="pure-control-group col s6">
							<label for="city">
								<fmt:message key="IncludeProviderView.city" bundle="${msg}"/>
							</label> 
							<input id="city" name="city" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informCity" bundle="${msg}"/>">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="password">
								<fmt:message key="IncludeProviderView.password" bundle="${msg}"/>
							</label> 
							<input id="password" name="password" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informPassword" bundle="${msg}"/>">
						</div>
						<div class="pure-control-group col s6">
							<label for="state">
								<fmt:message key="IncludeProviderView.state" bundle="${msg}"/>
							</label> 
							<input id="state" name="state" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informState" bundle="${msg}"/>">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="ddd">
								DDD
							</label> 
							<input id="ddd" name="ddd" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informDDD" bundle="${msg}"/>">
						</div>
						<div class="pure-control-group col s6">
							<label for="zip">
								<fmt:message key="IncludeProviderView.zip" bundle="${msg}"/>
							</label>
							<input id="zip" name="zip" type="text" placeholder="
							<fmt:message key="IncludeProviderView.informZIP" bundle="${msg}"/>">
						</div>
					</div>
					<div class="center">
						<button class="btn waves-effect waves-light" 
							type="submit" name="action">
							<fmt:message key="IncludeProviderView.submit" bundle="${msg}"/>
						</button>
					</div>
				</fieldset>
			</form>
		</div>
	</body>
</html>