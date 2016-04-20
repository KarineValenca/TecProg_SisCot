<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date, java.text.*"%>
<%@ page import=" dao.ProductDAO"%>
<%@ page import=" model.Product"%>
<%@ page import=" java.util.ArrayList"%>
<%
    ArrayList<Product> productList = new ArrayList<Product>();
    ProductDAO productdao = new ProductDAO();
    productList = productdao.listProducts();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String quotationDate = dateFormat.format(date);
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport"
            content="width=device-width, initial-scale=1, maximum-scale=1.0" />
        <title>Criar Nova Cotação</title>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
            rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet"
            media="screen,projection" />
        <link href="css/style.css" type="text/css" rel="stylesheet"
            media="screen,projection" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="../../bin/materialize.js"></script>
        <script src="js/init.js"></script>
    </head>
    <body class="blue lighten-5">
        <c:import url="header.jsp" />
        <br>
        <br>
        <br>
        <br>
        <div class="row center">
            <h1>Criar Cotação</h1>
        </div>
        <div class="container">
            <form action="IncludeQuotation" method="POST" class="center">
                <div class="input-field center">
                    Nome do Gerente:
                    <%=session.getAttribute("user")%>
                    <br>
                </div>
                <br>
                <div class="input-field center">
                    Data da Cotação:
                    <%=quotationDate%>
                    <br>
                </div>
                <br>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <c:forEach items="${products}" var="product">
                            <p>
                                <input type="checkbox" id="${product.productName}"
                                    name="${product.productName}" /> <label
                                    for="${product.productName}">${product.productName}</label>
                            </p>
                        </c:forEach>
                    </div>
                </div>
                <button class="btn waves-effect waves-light" type="submit"
                    name="action">Criar Cotação</button>
                <br> <br>
            </form>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <c:import url="footer.jsp" />
    </body>
</html>