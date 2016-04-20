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
        <br>
        <br>
        <%
            if (session != null) {
            	if (session.getAttribute("userType").equals("manager")) {
            %>
        <div class="row center">
            <a class="waves-effect waves-light btn" href="/SisCot/ConsultProduct">Criar
            Nova Cotação</a><br> <br>
        </div>
        <%
            }
            }
            %>
        <div class="row">
            <div class="col s10">
                <div class="col s3 offset-s3 ">
                    <div class="collection">
                        <li class="collection-item">ID da cotação #</li>
                        <c:forEach items="${quotationList}" var="quotation">
                            <a class="collection-item"
                                href="/SisCot/ShowQuotation.jsp?managerName=${quotation.managerName}&quotationDate=${quotation.quotationDate}
                                &quotationId=${quotation.id}&productList=${quotation.products}&quotationIsOn=${quotation.quotationIsOn}">
                            ${quotation.id} (${quotation.quotationIsOn}) </a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col s3  ">
                    <div class="collection">
                        <li class="collection-item">Gerente</li>
                        <c:forEach items="${quotationList}" var="quotation">
                            <a class="collection-item"
                                href="/SisCot/ShowQuotation.jsp?managerName=${quotation.managerName}&quotationDate=${quotation.quotationDate}
                                &quotationId=${quotation.id}&productList=${quotation.products}&quotationIsOn=${quotation.quotationIsOn}">
                            ${quotation.managerName} </a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col s3 ">
                    <div class="collection">
                        <li class="collection-item">Data</li>
                        <c:forEach items="${quotationList}" var="quotation">
                            <a class="collection-item"
                                href="/SisCot/ShowQuotation.jsp?managerName=${quotation.managerName}&quotationDate=${quotation.quotationDate}
                                &quotationId=${quotation.id}&productList=${quotation.products}&quotationIsOn=${quotation.quotationIsOn}">
                            ${quotation.quotationDate} </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>