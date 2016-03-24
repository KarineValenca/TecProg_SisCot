<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Alterar Produto</title>

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

	<div class="row">
		<div class="col s6 offset-s3">
			<div class="card-panel">
				<h2 class="truncate row center">Alterar Produto</h2>
				<h3 class="row center">
					<span class="roboto-bold"> Produto selecionado: <%=request.getParameter("productName")%></span>
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

								Nome do Produto <input
									value=<%=request.getParameter("productName")%> type="text"
									class="validate" name="name" /><br> <br>
							</div>

						</div>
						<button class="btn waves-effect waves-light" type="submit"
							name="action">Cadastrar</button>



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