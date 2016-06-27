<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    	<fmt:setBundle basename="resouces.messages" var="msg" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport"
            content="width=device-width, initial-scale=1, maximum-scale=1.0" />
        <title>
			<fmt:message key="product.product_edit" bundle="${msg}" />
		</title>
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
        <br><center>
        <a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a></center>
        <br>
        <div class="row">
            <div class="col s6 offset-s3">
                <div class="card-panel">
                    <h2 class="truncate row center">
                    	<fmt:message key="product.product_edit" bundle="${msg}" />
                    </h2>
                    <h3 class="row center">
                        <span class="roboto-bold"> 
                        <fmt:message key="product.product_selected" bundle="${msg}" />
                         <%=request.getParameter("productName")%></span>
                    </h3>
                </div>
            </div>
        </div>
        <div class="container">
            <h4 <%=request.getParameter("ProductName")%>></h4>
            <form action="UpdateProduct" method="POST" class="center">
                <div class="input-field center">
                    <input type="hidden" name="actualName"
                        value=<%=request.getParameter("productName")%>> <br>
                    <div class="card">
                        <div class="card-content">
                            <div class="row">
                                <div class="input-field col s12">
                                    <fmt:message key="product.name" bundle="${msg}" />
                                    <input
                                        value=<%=request.getParameter("productName")%> type="text"
                                        class="validate" name="name" />
                                     <br> <br>
                                </div>
                            </div>
                            <button class="btn waves-effect waves-light" type="submit"
                                name="action">
                                <fmt:message key="provider.submit" bundle="${msg}" />
                                </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <c:import url="footer.jsp" />
    </body>
</html>