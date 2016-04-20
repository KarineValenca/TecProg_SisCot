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
        <h3 class="row center">
            Cotação #<b><%=request.getParameter("quotationId")%></b>
        </h3>
        <br>
        <br>
        <div class="row">
            <div class="col s5 offset-s2">
                Criado por: <span class="blue-text text-darken-2"><%=request.getParameter("managerName")%></span><br>
                <br> Data: <span class="blue-text text-darken-2"><%=request.getParameter("quotationDate")%></span><br>
                <br>
                <%
                    if (request.getParameter("quotationIsOn").equals("true")) {
                    	if (session != null) {
                    		if (session.getAttribute("userType").equals("manager")) {
                    %>
                <a class="waves-effect waves-light btn-large red"
                    href="CloseQuotation?quotationId=<%=request.getParameter("quotationId")%>">
                <i class="material-icons right">av_timer</i> Fechar Cotação
                </a>
                <%
                    } else {
                    %>
                <%
                    }
                    	}
                    %>
                <h5>Cotação está em ANDAMENTO</h5>
                <%
                    } else {
                    %>
                Cotação está FECHADA
                <%
                    }
                    %>
            </div>
        </div>
        <br>
        <br>
        <br>
        <br>
        <%
            if (request.getParameter("quotationIsOn").equals("true")) {
            	if (session != null) {
            		if (session.getAttribute("userType").equals("provider")) {
            %>
        <div class="row">
            <div class="center">
                <a class="waves-effect waves-light btn-large blue"
                    href="Report?quotationId=<%=request.getParameter("quotationId")%>&isOn=<%=request.getParameter("quotationIsOn")%>">
                <i class="material-icons right">assignment</i> Disputar Cotação
                </a>
            </div>
        </div>
        <%
            }
            	}

            } else {
            %>
        <div class="row">
            <div class="center">
                <a class="waves-effect waves-light btn-large"
                    href="Report?quotationId=<%=request.getParameter("quotationId")%>&isOn=<%=request.getParameter("quotationIsOn")%>">
                <i class="material-icons right">description</i> Gerar Relatório da
                Cotação
                </a>
                <%
                    request.setAttribute("quotationId", request.getParameter("quotationId"));
                    %>
            </div>
        </div>
        <%
            }
            %>
    </body>
</html>