<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <title>Alterar Fornecedor</title>
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
        <!-- Start Page Loading -->
        <div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
            <a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
        </div>
        <!-- End Page Loading -->
        <br>
        <div id="login-page" class="row">
            <div class="col s4 offset-s4 z-depth-4 card-panel">
                <form class="login-form" action="Login" method="POST">
                    <div class="row margin">
                        <div class="input-field col s12">
                            <i class="mdi-social-person-outline prefix"></i>
                            <input id="username" type="text" name="login">
                            <label for="username" class="center-align"><fmt:message key="login.user" bundle="${msg}"/></label>
                        </div>
                    </div>
                    <div class="row margin">
                        <div class="input-field col s12">
                            <i class="mdi-action-lock-outline prefix"></i>
                            <input id="password" type="password" name="password">
                            <label for="password"><fmt:message key="login.password" bundle="${msg}"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12 m12 l12  login-text">
                            <input type="checkbox" id="remember-me" />
                            <label for="remember-me"><fmt:message key="login.credentials" bundle="${msg}"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <button class="btn waves-effect waves-light col s12  deep-orange darken-1 "  type="submit" name="action">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- ================================================
            Scripts
            ================================================ -->
        <!-- jQuery Library -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!--materialize js-->
        <script type="text/javascript" src="js/materialize.js"></script>
    </body>
</html>