<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<c:import url="header.jsp" />
	<div class="row center">
		<h1>Alterar Fornecedor</h1>
	</div>

	<h3 class="row center">
		Fornecedor selecionado: <b><%=session.getAttribute("user")%></b>
	</h3>

	<div class="container">
		<h4 <%=session.getAttribute("user")%>></h4>

		<form class="pure-form pure-form-aligned" action="UpdateProvider"
			method="POST" class="center">
			<fieldset>
				<div class="row">
					<div class="pure-control-group col s6">
						<label for="actualCnpj">CNPJ</label> <input id="actualCnpj"
							name="actualCnpj" type="text"
							value=<%=session.getAttribute("providerCnpj")%>>
					</div>
					<div class="pure-control-group col s6">
						<label for="actualPhone">Telefone</label> <input id="actualPhone"
							name="actualPhone" type="text"
							value=<%=session.getAttribute("actualPhone")%>>
					</div>
				</div>

				<div class="row">
					<div class="pure-control-group col s6">
						<label for="actualName">Nome</label> <input id="actualName"
							name="actualName" type="text"
							value=<%=session.getAttribute("actualName")%>>
					</div>
					<div class="pure-control-group col s6">
						<label for="actualAdress">Endereço</label> <input
							id="actualAdress" name="actualAdress" type="text"
							value=<%=session.getAttribute("actualAdress")%>>
					</div>
				</div>

				<div class="row">
					<div class="pure-control-group col s6">
						<label for="actualEmail">Email</label> <input id="actualEmail"
							name="actualEmail" type="text"
							value=<%=session.getAttribute("actualEmail")%>>
					</div>
					<div class="pure-control-group col s6">
						<label for="actualCity">Cidade</label> <input id="actualCity"
							name="actualCity" type="text"
							value=<%=session.getAttribute("actualCity")%>>
					</div>
				</div>

				<div class="row">
					<div class="pure-control-group col s6">
						<label for="actualPassword">Senha</label> <input
							id="actualPassword" name="actualPassword" type="text"
							value=<%=session.getAttribute("actualPassword")%>>
					</div>
					<div class="pure-control-group col s6">
						<label for="actualState">Estado</label> <input id="actualState"
							name="actualState" type="text"
							value=<%=session.getAttribute("actualState")%>>
					</div>
				</div>

				<div class="row">
					<div class="pure-control-group col s6">
						<label for="actualDdd">DDD</label> <input id="actualDdd"
							name="actualDdd" type="text"
							value=<%=session.getAttribute("actualDdd")%>>
					</div>
					<div class="pure-control-group col s6">
						<label for="actualZip">CEP</label> <input id="actualZip"
							name="actualZip" type="text"
							value=<%=session.getAttribute("actualZip")%>>
					</div>
				</div>

				<%
					String user = (String) session.getAttribute("userType");
					if (user.equals("manager")) {
				%>
				<div class="input-field center">
					<input type="checkbox" name="authorized" class="filled-in"
						id="filled-in-box" <%=session.getAttribute("authorized")%> /> <label
						for="filled-in-box">Fornecedor Autorizado</label> <br> <br>
					<br> <br>
				</div>
				<%
					}
				%>

				<div class="center">
					<button class="btn waves-effect waves-light" type="submit"
						name="action">Cadastrar</button>
				</div>
			</fieldset>
		</form>
	</div>

</body>
</html>