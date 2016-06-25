<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <c:import url="header.jsp" />
        <br>
        <br>
        <a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
        <div class="row center">
        
            <a class="waves-effect waves-light btn"
                href="/SisCot/IncludeProviderView.jsp"><fmt:message key="providers.register" bundle="${msg}"/></a><br>
            <br>
        </div>
        <div class="row">
            <div class="col s4 offset-s4 z-depth-4 card-panel">
                <div class="collection">
                    <li class="collection-item center"><fmt:message key="providers.providers" bundle="${msg}"/></li>
                    <c:forEach items="${providers}" var="provider">
                        <a class="collection-item"
                            href="/SisCot/ShowProvider.jsp?
                            providerCnpj=${provider.providerCnpj}
                            &providerName=${provider.providerName}
                            &providerEmail=${provider.providerEmail}
                            &providerPassword=${provider.providerPassword}
                            &providerDdd=${provider.providerDdd}
                            &providerPhone=${provider.providerPhone}
                            &providerAdress=${provider.providerAdress}
                            &providerCity=${provider.providerCity}
                            &providerState=${provider.providerState}
                            &providerZip=${provider.providerZip}">
                        ${provider.providerName} </a>
                    </c:forEach>
                </div>
            </div>
            <!-- 
                <div class="col s3">
                	<div class="collection">
                		<li class="collection-item">Descrição</li>
                		<c:forEach items="${providers}" var="provider">
                			<a class="collection-item"
                				href="/SisCot/ShowProduct.jsp?productName=${product.productName}&productDescription=${product.productDescription}">
                				${product.productDescription} </a>
                			<br>
                		</c:forEach>
                	</div>
                </div>
                -->
        </div>
    </body>
</html>